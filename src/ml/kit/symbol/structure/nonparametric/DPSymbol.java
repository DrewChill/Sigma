package ml.kit.symbol.structure.nonparametric;

import ml.kit.structs.asm.MLObject;
import ml.kit.symbol.Symbol;
import ml.kit.symbol.entropy.LocalEntropy;

public class DPSymbol<T extends MLObject> extends Symbol<T>{

	private double beta = 0.5;
	
	public DPSymbol(LocalEntropy<T> localEntropy, double beta) {
		super(localEntropy);
		this.beta = beta;
	}

	@Override
	public double calcAssignmentLikelihood(T item, double vSize, int dimension) {
		double vb = vSize * beta;
		
		double fk =  (localEntropy.observationCount(item) + beta) / 
		             (((double)clusterSize()) + vb);
		return       fk;
	}

}
