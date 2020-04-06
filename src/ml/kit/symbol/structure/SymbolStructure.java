package ml.kit.symbol.structure;

import ml.kit.structs.asm.MLObject;
import ml.kit.symbol.Symbol;

public abstract class SymbolStructure<T extends MLObject> {
	
	StructureInfo<T> behavior;
	
	public SymbolStructure(StructureInfo<T> behavior) {
		this.behavior = behavior;
	}
	
	public Symbol<T> createNewSymbol(){
		return behavior.createNewSymbol();
	}
	
	public abstract Symbol<T> excite(T item, double vSize, int capacity);
	
	public abstract Symbol<T> inhibit(T item, double vSize, int capacity);

}
