package ml.kit.symbol.structure;

import ml.kit.structs.asm.MLObject;
import ml.kit.symbol.Symbol;
import ml.kit.symbol.generator.inference.InferenceInfo;

public abstract class SymbolStructure<T extends MLObject> {
	
	protected InferenceInfo behavior;
	
	public SymbolStructure(InferenceInfo behavior) {
		this.behavior = behavior;
	}
	
	public abstract Symbol<T> excite(T item, double vSize, int capacity);
	
	public abstract Symbol<T> inhibit(T item, double vSize, int capacity);

}
