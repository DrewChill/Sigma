package archive;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import ml.observer.emitter.Emitter;
import ml.observer.AbstractObserver;

public abstract class AbstractEmitter<T> implements Emitter<T>,Runnable {

	protected final Queue<T> inputBuffer = new ConcurrentLinkedQueue<>();

	private Random r = new Random();

	public AbstractEmitter() {
		new Thread(this).start();
	}

	public int vocabularySize() {
		return symbolGenerator.allClusters().size();
	}

	public void reuptake(StochasticSymbol<?> signaler) {
		synapticEntropy.addObservation((StochasticSymbol<T>) signaler);
	}

	public void degenerate(StochasticSymbol<?> signaler) {
		synapticEntropy.decayObservation((StochasticSymbol<T>) signaler);
	}

	public int getConnectionDimension() {
		return synapticEntropy.size;
	}

	public Collection<StochasticSymbol<T>> getConnections() {
		return synapticEntropy.getStationaryDistribution().keySet();
	}

	private StochasticSymbol<T> sample() {
		Map<StochasticSymbol<T>, Double> stationaryDistribution = synapticEntropy.getStationaryDistribution();
		double sample = r.nextDouble();
		for (StochasticSymbol<T> obj : stationaryDistribution.keySet()) {
			if (stationaryDistribution.get(obj) > sample) {
				return obj;
			}
		}
		return null;
	}

	public Collection<StochasticSymbol<T>> fire(double duration, double weight) {
		List<StochasticSymbol<T>> ret = new ArrayList<>();
		double weightedSize = (double) synapticEntropy.size * weight;
		int objsToSample = (int) (((weightedSize / duration)) * synapticEntropy.size);
		for (int i = 0; i < objsToSample; i++) {
			ret.add(sample());
		}

		return ret;
	}

	public abstract ProbabilisticSymbol<T> fuseSymbol(T item, int populationSize, double totalAssignmentLikelihood,
			Map<StochasticSymbol<T>, Double> likelihoodForSymbol, AbstractObserver<T> behavior);

	// ------------------

}
