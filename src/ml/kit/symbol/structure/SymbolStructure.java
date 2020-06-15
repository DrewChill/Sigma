package ml.kit.symbol.structure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import ml.kit.structs.asm.MLObject;
import ml.kit.structs.group.Synapse;
import ml.kit.symbol.Symbol;

public abstract class SymbolStructure<T extends MLObject> {

	protected StructureInfo<T> behavior;
	private Synapse<Symbol<T>> downstream = null;
	private volatile int size = 0;
	public List<Symbol<T>> allClusters = new ArrayList<>();

	public SymbolStructure(StructureInfo<T> behavior) {
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

	protected abstract Symbol<T> excite(T item, double vSize, int capacity);

	protected abstract T inhibit(double vSize, int capacity);

	public Collection<Symbol<T>> generateSymbolStream(double weight) {
		List<Symbol<T>> stream = new ArrayList<>();
		Set<Synapse<T>> synapses = behavior.structureEntropy.getSynapses();

		for (Synapse<T> synapse : synapses) {
			stream.addAll(synapse.fire((double) size * weight, weight));
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
