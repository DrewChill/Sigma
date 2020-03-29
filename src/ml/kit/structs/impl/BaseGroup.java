package ml.kit.structs.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import ml.kit.cluster.Cluster;
import ml.kit.cluster.vocabulary.Vocabulary;
import ml.kit.structs.group.Group;
import ml.kit.structs.item.Item;

public class BaseGroup<T extends Serializable> extends Group<T>{

	public BaseGroup(Vocabulary<T> vocabulary) {
		super(vocabulary);
	}

	@Override
	public Cluster<T> sampleGroupForCluster(Item<T> item, int populationSize,
			double totalAssignmentLikelihood) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(bos);
			oos.writeObject(item.getValue());
			oos.flush();
			return vocabulary.decodeBytes(bos.toByteArray());
		} catch (IOException e) {
			return null;
		}
	}
	
}
