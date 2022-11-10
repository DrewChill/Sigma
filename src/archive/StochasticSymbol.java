package archive;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import ml.kit.function.SymbolShape;

public abstract class StochasticSymbol<T> {
	
	public ObservationHistory<T> observationHistory;
	public byte[] clusterIndicator = null;
	private static Random r = new Random(System.currentTimeMillis());
	public SymbolShape<T> fk;
	protected Set<AbstractEmitter<T>> contributors = new HashSet<>();
	
	public StochasticSymbol(ObservationHistory<T> observationHistory, SymbolShape<T> fk) {
		this.observationHistory = observationHistory;
		this.fk = fk;
	}
		
	public synchronized double updateWeight(T obj, double update) {
		double ret = (update > 0) ? observationHistory.addObservation(obj) : observationHistory.decayObservation(obj);
		fk.update(observationHistory.getObjsAndCount());
		return ret;
	}
	
	public int clusterSize() {
		return observationHistory.size;
	}

	public T sample(){
		Map<T, Double> stationaryDistribution = observationHistory.getStationaryDistribution();
		double sample = r.nextDouble();
		double p[] = new double[stationaryDistribution.size()];
		double pTotal = 0.0;
		List<T> objs = new ArrayList<>();
		objs.addAll(stationaryDistribution.keySet());
		for(int i=0; i<stationaryDistribution.size(); i++) {
			pTotal += stationaryDistribution.get(objs.get(i));
			p[i] = pTotal;
		}
		
		for(int i=0; i<stationaryDistribution.size(); i++) {
			if(sample < p[i]) {
				return objs.get(i);
			}
		}
		return null;
	}
	
	public InputStream propagate() {
		return propagate(1.0);
	}
	
	public InputStream propagate(double weight) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(bos);
			int objsToSample = (int)(observationHistory.size * weight);
			for(int i=0; i<objsToSample; i++) {
				oos.writeObject(sample());
			}
			oos.flush();
			
			return new ByteArrayInputStream(bos.toByteArray());
		} catch (IOException e) {
			return null;
		}
	}

	public void addContributor(AbstractEmitter<?> intraface) {
		contributors.add((AbstractEmitter<T>) intraface);
	}
	
	public String toString() {
		return "size:"+this.clusterSize();
	}
	
	public abstract double calcAssignmentLikelihood(T item, double vSize, int dimension);
	
}
