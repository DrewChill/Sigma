package ml.kit.observer.symbol.relation.base;

import java.util.HashMap;
import java.util.Map;

import ml.kit.structs.asm.MLObject;
import ml.kit.observer.symbol.Symbol;
import ml.kit.observer.history.ObservationHistory;

public class StableSymbol<T extends MLObject> extends Symbol<T>{

	Map<T, Integer> wordCount = new HashMap<>();
	
	public StableSymbol(ObservationHistory<T> observationHistory) {
		super(observationHistory, null);
	}

	@Override
	public double calcAssignmentLikelihood(T item, double vSize, int dimension) {
		return (observationHistory.size == 0 || observationHistory.observationCount(item) > 0) ? 0.0 : 1.0;
	}

}
