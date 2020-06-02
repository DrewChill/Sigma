package ml.kit.symbol;

import ml.kit.structs.asm.MLObject;

public class ProbabilisticSymbol<T extends MLObject>{

	public Symbol<T> symbol;
	public double likelihood;
	
	public ProbabilisticSymbol(Symbol<T> symbol, double likelihood) {
		this.likelihood = likelihood;
	}
	
}
