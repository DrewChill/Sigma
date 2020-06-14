package ml.kit.structs.impl.dp;

import java.util.Map;

import ml.kit.structs.asm.MLObject;
import ml.kit.structs.group.Synapse;
import ml.kit.symbol.ProbabilisticSymbol;
import ml.kit.symbol.Symbol;
import ml.kit.symbol.SymbolGenerator;
import ml.kit.symbol.structure.StructureInfo;

public class DPSynapse<T extends MLObject> extends Synapse<T>{

	public DPSynapse(SymbolGenerator<T> vocabulary) {
		super(vocabulary);
	}

	@Override
	public ProbabilisticSymbol<T> fuseSymbol(T item, int populationSize, double totalAssignmentLikelihood,
			Map<Symbol<T>, Double> likelihoodForSymbol, StructureInfo<T> behavior) {
		return null;
	}

}
