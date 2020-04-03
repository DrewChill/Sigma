package ml.kit.structs.impl.dp;

import java.io.InputStream;

import ml.kit.cluster.vocabulary.Vocabulary;
import ml.kit.structs.group.Context;
import ml.kit.structs.group.Synapse;

public class DPContext<T> extends Context<T>{

	public DPContext(Vocabulary<T> vocabulary) {
		super(vocabulary);
	}

	@Override
	public Synapse<T> createGroup(InputStream input) {
		Synapse<T> groupForInputStream = new DPGroup<T>(vocabulary);
		Thread groupThread = new Thread(groupForInputStream);
		groupThread.start();
		return groupForInputStream;
	}

}
