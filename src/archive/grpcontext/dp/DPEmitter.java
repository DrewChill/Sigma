package archive.grpcontext.dp;

import java.util.Map;

import archive.asm.Observable;
import archive.AbstractEmitter;
import archive.ProbabilisticSymbol;
import archive.StochasticSymbol;
import ml.observer.symbol.NullGenerator;
import ml.observer.AbstractObserver;

public class DPEmitter<T extends Observable> extends AbstractEmitter<T> {

	public DPEmitter(NullGenerator<T> vocabulary) {
		super(vocabulary);
	}

	@Override
	public ProbabilisticSymbol<T> fuseSymbol(T item, int populationSize, double totalAssignmentLikelihood,
			Map<StochasticSymbol<T>, Double> likelihoodForSymbol, AbstractObserver<T> behavior) {
		return null;
	}

}
