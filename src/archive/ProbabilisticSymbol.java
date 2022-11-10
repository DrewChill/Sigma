package archive;

import ml.kit.structs.asm.Observable;

public class ProbabilisticSymbol<T extends Observable>{

	public StochasticSymbol<T> symbol;
	public double likelihood;
	
	public ProbabilisticSymbol(StochasticSymbol<T> symbol, double likelihood) {
		this.likelihood = likelihood;
	}
	
}
