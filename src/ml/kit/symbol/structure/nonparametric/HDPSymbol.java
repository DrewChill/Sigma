package ml.kit.symbol.structure.nonparametric;

import java.io.InputStream;

import ml.kit.structs.asm.MLObject;
import ml.kit.symbol.Symbol;
import ml.kit.symbol.entropy.LocalEntropy;

public class HDPSymbol<T extends MLObject> extends Symbol<T>{
	
	private double beta = 0.5;
	
	public HDPSymbol(LocalEntropy<T> localEntropy, double beta) {
		super(localEntropy);
		this.beta = beta;
	}

	@Override
	public double calcAssignmentLikelihood(T item, double vSize, int dimension) {
		double vb = vSize * beta;
		
		double fk =  (localEntropy.observationCount(item) + beta) / 
		             (((double)clusterSize()) + vb);
		return       ((double)dimension) * fk;
	}

	@Override
	public InputStream propagate() {
		// TODO Auto-generated method stub
		return null;
	}

}
