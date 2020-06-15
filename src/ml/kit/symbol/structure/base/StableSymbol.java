package ml.kit.symbol.structure.base;

import java.util.HashMap;
import java.util.Map;

import ml.kit.structs.asm.MLObject;
import ml.kit.symbol.Symbol;
import ml.kit.symbol.entropy.LocalEntropy;

public class StableSymbol<T extends MLObject> extends Symbol<T>{

	Map<T, Integer> wordCount = new HashMap<>();
	
	public StableSymbol(LocalEntropy<T> localEntropy) {
		super(localEntropy, null);
	}

	@Override
	public double calcAssignmentLikelihood(T item, double vSize, int dimension) {
		return (localEntropy.size == 0 || localEntropy.observationCount(item) > 0) ? 0.0 : 1.0;
	}

}
