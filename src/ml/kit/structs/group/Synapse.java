package ml.kit.structs.group;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import ml.kit.structs.asm.MLObject;
import ml.kit.symbol.ProbabilisticSymbol;
import ml.kit.symbol.Symbol;
import ml.kit.symbol.SymbolGenerator;
import ml.kit.symbol.entropy.LocalEntropy;
import ml.kit.symbol.structure.StructureInfo;

public abstract class Synapse<T extends MLObject> implements Runnable {

	protected LocalEntropy<Symbol<T>> synapticEntropy;
	protected SymbolGenerator<T> symbolGenerator;
	protected Queue<T> bytesWaiting = new ConcurrentLinkedQueue<>();
	protected Collection<T> items = new ArrayList<>();
	private Random r = new Random();

	protected Pipe recvStream; // TODO

	public Synapse(SymbolGenerator<T> vocabulary) {
		this.symbolGenerator = vocabulary;
		this.synapticEntropy = vocabulary.registerSynapse(this);
		new Thread(this).start();
	}

	public int vocabularySize() {
		return symbolGenerator.allClusters().size();
	}

	public void reuptake(Symbol<?> signaler) {
		synapticEntropy.addObservation((Symbol<T>) signaler);
	}

	public void degenerate(Symbol<?> signaler) {
		synapticEntropy.decayObservation((Symbol<T>) signaler);
	}

	public int getConnectionDimension() {
		return synapticEntropy.size;
	}

	public Collection<Symbol<T>> getConnections() {
		return synapticEntropy.getStationaryDistribution().keySet();
	}

	public void addData(T item) {
		synchronized(bytesWaiting) {
			bytesWaiting.add(item);
			bytesWaiting.notify();
		}
	}

	public void addData(Collection<T> items) {
		synchronized(bytesWaiting) {
			bytesWaiting.addAll(items);
			bytesWaiting.notify();
		}
	}

	private Symbol<T> sample() {
		Map<Symbol<T>, Double> stationaryDistribution = synapticEntropy.getStationaryDistribution();
		double sample = r.nextDouble();
		for (Symbol<T> obj : stationaryDistribution.keySet()) {
			if (stationaryDistribution.get(obj) > sample) {
				return obj;
			}
		}
		return null;
	}
	
//	public Symbol<T> sample(T data) {
//		Map<Symbol<T>, Double> stationaryDistribution = synapticEntropy.getStationaryDistribution();
//		List<Symbol<T>> clusters = new ArrayList<>();
//		clusters.addAll(stationaryDistribution.keySet());
//		
//		Map<Symbol<T>, Double> likelihoodForSymbol = new HashMap<>();
//		for (Symbol<T> cluster : stationaryDistribution.keySet()) {
//			double likelihood = cluster.calcAssignmentLikelihood(data, 0, 0);
//			likelihoodForSymbol.put(cluster, likelihood);
//		}
//		
//		double pSum = 0.0;
//		double[] p = new double[clusters.size()];
//		int index = 0;
//
//		for (Symbol<T> cluster : clusters) {
//			Double likelihood = likelihoodForSymbol.get(cluster);
//			likelihood = likelihood == null ? 0.0 : likelihood;
//			pSum += likelihood;
//			p[index] = pSum;
//			index++;
//		}
//		p[p.length - 1] = pSum;
//		
//		Symbol<T> ret = null;
//		double clusterSelector = r.nextDouble() * pSum;
//		for (int i = 0; i < p.length; i++) {
//			System.out.print(p[i]+",");
//			if (clusterSelector < p[i]) {
//				ret = clusters.get(i);
//				break;
//			}
//		}
//		System.out.println(" ----> "+ret);
//		return ret;
//	}

	public Collection<Symbol<T>> fire(double duration, double weight) {
		List<Symbol<T>> ret = new ArrayList<>();
		double weightedSize = (double) synapticEntropy.size * weight;
		int objsToSample = (int) (((weightedSize / duration)) * synapticEntropy.size);
		for (int i = 0; i < objsToSample; i++) {
			ret.add(sample());
		}

		return ret;
	}

	public abstract ProbabilisticSymbol<T> fuseSymbol(T item, int populationSize, double totalAssignmentLikelihood,
			Map<Symbol<T>, Double> likelihoodForSymbol, StructureInfo<T> behavior);

	// ------------------

	@Override
	public void run() {
		while (true) {
			T data = null;
			synchronized (bytesWaiting) {
				if (bytesWaiting.isEmpty()) {
					try {
						//System.out.println("waiting for data...");
						bytesWaiting.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//System.out.println("decoding data...");
				data = bytesWaiting.poll();
			}
			data.registerSynapseToSymbolGeneratorID(this, symbolGenerator.id);
			//System.out.println("queueing data...");
			symbolGenerator.queueMLObject(data);
			items.add(data);
		}
	}

}
