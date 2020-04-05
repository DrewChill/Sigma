package ml.kit.symbol;

import ml.kit.structs.asm.MLObject;

public class StochasticSymbol<T extends MLObject>{

	public Symbol<T> symbol;
	public double likelihood;
	
	public StochasticSymbol(Symbol<T> symbol, double likelihood) {
		this.likelihood = likelihood;
	}
	
}
