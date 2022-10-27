package ml.kit.observer.symbol.relation.nonparametric;

import ml.kit.function.SymbolFunction;
import ml.kit.structs.asm.MLObject;
import ml.kit.observer.symbol.Symbol;
import ml.kit.observer.history.ObservationHistory;

public class DPSymbol<T extends MLObject> extends Symbol<T>{

	
	public DPSymbol(ObservationHistory<T> observationHistory, SymbolFunction<T> fk) {
		super(observationHistory, fk);
	}

	@Override
	public double calcAssignmentLikelihood(T item, double vSize, int dimension) {
		return  fk.calculate(item);
	}

}
