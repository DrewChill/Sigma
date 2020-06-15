package ml.kit.symbol;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import ml.kit.function.DensityFunction;
import ml.kit.structs.asm.MLObject;
import ml.kit.structs.group.Synapse;
import ml.kit.symbol.entropy.LocalEntropy;

public abstract class Symbol<T extends MLObject> extends MLObject{
	
	protected LocalEntropy<T> localEntropy;
	public byte[] clusterIndicator = null;
	private Random r = new Random();
	protected DensityFunction<T> fk;
	protected Set<Synapse<T>> contributors = new HashSet<>();
	
	public Symbol(LocalEntropy<T> localEntropy, DensityFunction<T> fk) {
		this.localEntropy = localEntropy;
		this.fk = fk;
	}
		
	public synchronized double updateWeight(T obj, double update) {
		double ret = (update > 0) ? localEntropy.addObservation(obj) : localEntropy.decayObservation(obj);
		fk.update(localEntropy.getObjsAndCount());
		return ret;
	}
	
	public int clusterSize() {
		return localEntropy.size;
	}
	
	public T sampleItemFromCluster(){
		Map<T, Double> stationaryDistribution = localEntropy.getStationaryDistribution();
		double sample = r.nextDouble();
		for(T obj : stationaryDistribution.keySet()) {
			if(stationaryDistribution.get(obj) > sample) {
				return obj;
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
			int objsToSample = (int)(localEntropy.size * weight);
			for(int i=0; i<objsToSample; i++) {
				oos.writeObject(sampleItemFromCluster());
			}
			oos.flush();
			
			return new ByteArrayInputStream(bos.toByteArray());
		} catch (IOException e) {
			return null;
		}
	}
	
	public void addContributor(Synapse<?> synapse) {
		contributors.add((Synapse<T>) synapse);
	}
	
	public abstract double calcAssignmentLikelihood(T item, double vSize, int dimension);
	
}
