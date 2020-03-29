package ml.kit.structs.impl.hdp;

import java.io.InputStream;

import ml.kit.cluster.vocabulary.Vocabulary;
import ml.kit.structs.group.Context;
import ml.kit.structs.group.Group;

public class HDPContext<T> extends Context<T> {
		
	public HDPContext(Vocabulary<T> vocabulary) {
		super(vocabulary);
	}

	@Override
	public Group<T> createGroup(InputStream input) {
		Group<T> groupForInputStream = new HDPGroup<T>(vocabulary);
		Thread groupThread = new Thread(groupForInputStream);
		groupThread.start();
		return groupForInputStream;
	}

}
