package ml.observer.symbol.relation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import archive.asm.Observable;
import archive.AbstractEmitter;
import ml.observer.AbstractObserver;
import archive.StochasticSymbol;

public abstract class SymbolRelation<T extends Observable> {

	protected AbstractObserver<T> behavior;
	private AbstractEmitter<StochasticSymbol<T>> downstream = null;
	private volatile int size = 0;
	public List<StochasticSymbol<T>> allClusters = new ArrayList<>();

	public SymbolRelation(AbstractObserver<T> behavior) {
		this.behavior = behavior;
	}

	public StochasticSymbol<T> createNewSymbol() {
		return behavior.createNewSymbol();
	}

	public StochasticSymbol<T> stimulate(T item, double vSize, int capacity) {
		size++;
		return excite(item, vSize, capacity);
	}

	public T decay(double vSize, int capacity) {
		size--;
		return inhibit(vSize, capacity);
	}

	public abstract RelationShape globalShape();

	protected abstract StochasticSymbol<T> excite(T item, double vSize, int capacity);

	protected abstract T inhibit(double vSize, int capacity);

	public Collection<StochasticSymbol<T>> generateSymbolStream(double weight) {
		List<StochasticSymbol<T>> stream = new ArrayList<>();
		Set<AbstractEmitter<T>> synaps = behavior.relationHistory.getSynapses();

		for (AbstractEmitter<T> intraface : synaps) {
			stream.addAll(intraface.fire((double) size * weight, weight));
		}

		return stream;
	}

	public void propagate() {
		propagate(1.0);
	}

	private void propagate(double weight) {
		if (downstream == null) {
			downstream = behavior.getNextContext().addInputStream();
		}

		if (downstream != null) {
			downstream.addData(generateSymbolStream(weight));
		}
	}

}
