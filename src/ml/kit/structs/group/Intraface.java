package ml.kit.structs.group;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import ml.kit.structs.asm.MLObject;
import archive.ProbabilisticSymbol;
import ml.kit.observer.symbol.Symbol;
import ml.kit.observer.symbol.SymbolGenerator;
import ml.kit.observer.history.ObservationHistory;
import ml.kit.observer.Observer;

public abstract class Intraface<T extends MLObject> implements Runnable {

	protected ObservationHistory<Symbol<T>> synapticEntropy;
	protected SymbolGenerator<T> symbolGenerator;
	protected Queue<T> bytesWaiting = new ConcurrentLinkedQueue<>();
	protected Collection<T> items = new ArrayList<>();
	private Random r = new Random();

	protected Pipe recvStream; // TODO

	public Intraface(SymbolGenerator<T> vocabulary) {
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
			Map<Symbol<T>, Double> likelihoodForSymbol, Observer<T> behavior);

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
