package ml.observer.symbol.relation.nonparametric;

import ml.function.SymbolShape;
import archive.asm.Observable;
import archive.StochasticSymbol;
import archive.ObservationHistory;

public class DPSymbol<T extends Observable> extends StochasticSymbol<T> {

	
	public DPSymbol(ObservationHistory<T> observationHistory, SymbolShape<T> fk) {
		super(observationHistory, fk);
	}

	@Override
	public double calcAssignmentLikelihood(T item, double vSize, int dimension) {
		return  fk.calculate(item);
	}

}
