package ml.kit.structs.group;

import ml.kit.symbol.Symbol;

public interface Generator<T> {
	
	public Context<T> newContext(Symbol<T> parent);

}
