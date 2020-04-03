package ml.kit.structs.impl.hdp;

import java.io.InputStream;

import ml.kit.cluster.vocabulary.Vocabulary;
import ml.kit.structs.group.Context;
import ml.kit.structs.group.Synapse;

public class HDPContext<T> extends Context<T> {
		
	public HDPContext(Vocabulary<T> vocabulary) {
		super(vocabulary);
	}

	@Override
	public Synapse<T> createGroup(InputStream input) {
		Synapse<T> groupForInputStream = new HDPGroup<T>(vocabulary);
		Thread groupThread = new Thread(groupForInputStream);
		groupThread.start();
		return groupForInputStream;
	}

}
