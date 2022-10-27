package ml.kit.observer.symbol.relation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import ml.kit.structs.asm.MLObject;
import ml.kit.structs.group.Intraface;
import ml.kit.observer.Observer;
import ml.kit.observer.symbol.Symbol;

public abstract class SymbolRelation<T extends MLObject> {

	protected Observer<T> behavior;
	private Intraface<Symbol<T>> downstream = null;
	private volatile int size = 0;
	public List<Symbol<T>> allClusters = new ArrayList<>();

	public SymbolRelation(Observer<T> behavior) {
		this.behavior = behavior;
	}

	public Symbol<T> createNewSymbol() {
		return behavior.createNewSymbol();
	}

	public Symbol<T> stimulate(T item, double vSize, int capacity) {
		size++;
		return excite(item, vSize, capacity);
	}

	public T decay(double vSize, int capacity) {
		size--;
		return inhibit(vSize, capacity);
	}

	public abstract RelationShape globalShape();

	protected abstract Symbol<T> excite(T item, double vSize, int capacity);

	protected abstract T inhibit(double vSize, int capacity);

	public Collection<Symbol<T>> generateSymbolStream(double weight) {
		List<Symbol<T>> stream = new ArrayList<>();
		Set<Intraface<T>> synaps = behavior.relationHistory.getSynapses();

		for (Intraface<T> intraface : synaps) {
			stream.addAll(intraface.fire((double) size * weight, weight));
		}

		return stream;
	}

	public void propagate() {
		propagate(1.0);
	}

	public void propagate(double weight) {
		if (downstream == null) {
			downstream = behavior.getNextContext().addInputStream();
		}

		if (downstream != null) {
			downstream.addData(generateSymbolStream(weight));
		}
	}

}
