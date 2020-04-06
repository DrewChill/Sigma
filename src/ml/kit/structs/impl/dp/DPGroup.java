package ml.kit.structs.impl.dp;

import ml.kit.structs.group.Synapse;
import ml.kit.structs.item.Stimulus;
import ml.kit.symbol.Symbol;
import ml.kit.symbol.SymbolGenerator;

public class DPGroup<T> extends Synapse<T>{

	public DPGroup(SymbolGenerator<T> vocabulary) {
		super(vocabulary);
	}

	@Override
	public Symbol<T> sampleGroupForCluster(Stimulus<T> item, int populationSize, double totalAssignmentLikelihood) {
		return null;
	}

}
