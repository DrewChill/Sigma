package ml.kit.observer.symbol.relation.base;

import java.util.HashMap;
import java.util.Map;

import ml.kit.structs.asm.Observable;
import archive.StochasticSymbol;
import archive.ObservationHistory;

public class StableSymbol<T extends Observable> extends StochasticSymbol<T> {

	Map<T, Integer> wordCount = new HashMap<>();
	
	public StableSymbol(ObservationHistory<T> observationHistory) {
		super(observationHistory, null);
	}

	@Override
	public double calcAssignmentLikelihood(T item, double vSize, int dimension) {
		return (observationHistory.size == 0 || observationHistory.observationCount(item) > 0) ? 0.0 : 1.0;
	}

}
