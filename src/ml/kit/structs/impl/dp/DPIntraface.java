package ml.kit.structs.impl.dp;

import java.util.Map;

import ml.kit.structs.asm.MLObject;
import ml.kit.structs.group.Intraface;
import archive.ProbabilisticSymbol;
import ml.kit.observer.symbol.Symbol;
import ml.kit.observer.symbol.SymbolGenerator;
import ml.kit.observer.Observer;

public class DPIntraface<T extends MLObject> extends Intraface<T> {

	public DPIntraface(SymbolGenerator<T> vocabulary) {
		super(vocabulary);
	}

	@Override
	public ProbabilisticSymbol<T> fuseSymbol(T item, int populationSize, double totalAssignmentLikelihood,
			Map<Symbol<T>, Double> likelihoodForSymbol, Observer<T> behavior) {
		return null;
	}

}
