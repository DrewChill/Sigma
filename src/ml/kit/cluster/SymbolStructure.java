package ml.kit.cluster;

import ml.kit.structs.item.Stimulus;

public interface SymbolStructure<T> {
	
	public Symbol<T> signalSymbolStructure(Stimulus<T> item);

}
