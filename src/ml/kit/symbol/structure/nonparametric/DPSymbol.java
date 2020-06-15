package ml.kit.symbol.structure.nonparametric;

import ml.kit.function.DensityFunction;
import ml.kit.structs.asm.MLObject;
import ml.kit.symbol.Symbol;
import ml.kit.symbol.entropy.LocalEntropy;

public class DPSymbol<T extends MLObject> extends Symbol<T>{

	
	public DPSymbol(LocalEntropy<T> localEntropy, DensityFunction<T> fk) {
		super(localEntropy, fk);
	}

	@Override
	public double calcAssignmentLikelihood(T item, double vSize, int dimension) {
		return  fk.calculate(item);
	}

}
