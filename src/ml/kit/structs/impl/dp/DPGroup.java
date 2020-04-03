package ml.kit.structs.impl.dp;

import ml.kit.cluster.Symbol;
import ml.kit.cluster.vocabulary.Vocabulary;
import ml.kit.structs.group.Synapse;
import ml.kit.structs.item.Stimulus;

public class DPGroup<T> extends Synapse<T>{

	public DPGroup(Vocabulary<T> vocabulary) {
		super(vocabulary);
	}

	@Override
	public Symbol<T> sampleGroupForCluster(Stimulus<T> item, int populationSize, double totalAssignmentLikelihood) {
		return null;
	}

}
