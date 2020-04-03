package ml.kit.structs.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import ml.kit.cluster.Symbol;
import ml.kit.cluster.vocabulary.Vocabulary;
import ml.kit.structs.group.Synapse;
import ml.kit.structs.item.Stimulus;

public class BaseGroup<T extends Serializable> extends Synapse<T>{

	public BaseGroup(Vocabulary<T> vocabulary) {
		super(vocabulary);
	}

	@Override
	public Symbol<T> sampleGroupForCluster(Stimulus<T> item, int populationSize,
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
