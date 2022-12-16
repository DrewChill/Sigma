package ml.observer.symbol.relation.nonparametric;

import ml.function.SymbolShape;
import archive.asm.Observable;
import archive.StochasticSymbol;
import archive.ObservationHistory;

public class HDPSymbol<T extends Observable> extends StochasticSymbol<T> {
		
	public HDPSymbol(ObservationHistory<T> observationHistory, SymbolShape<T> fk) {
		super(observationHistory, fk);
	}

	@Override
	public double calcAssignmentLikelihood(T item, double vSize, int dimension) {
		return contributors.size() * fk.calculate(item);
	}

}
