package archive.grpcontext;

import java.util.Map;

import archive.asm.Observable;
import archive.AbstractEmitter;
import archive.ProbabilisticSymbol;
import archive.StochasticSymbol;
import ml.kit.observer.symbol.NullGenerator;
import ml.kit.observer.AbstractObserver;

public class BaseGroup<T extends Observable> extends AbstractEmitter<T> {

	public BaseGroup(NullGenerator<T> vocabulary) {
		super(vocabulary);
	}

	@Override
	public ProbabilisticSymbol<T> fuseSymbol(T item, int populationSize, double totalAssignmentLikelihood,
			Map<StochasticSymbol<T>, Double> likelihoodForSymbol, AbstractObserver<T> behavior) {
		return null;
	}
	
}
