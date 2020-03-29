package ml.kit.structs.impl.dp;

import ml.kit.cluster.Cluster;
import ml.kit.cluster.vocabulary.Vocabulary;
import ml.kit.structs.group.Group;
import ml.kit.structs.item.Item;

public class DPGroup<T> extends Group<T>{

	public DPGroup(Vocabulary<T> vocabulary) {
		super(vocabulary);
	}

	@Override
	public Cluster<T> sampleGroupForCluster(Item<T> item, int populationSize, double totalAssignmentLikelihood) {
		return null;
	}

}
