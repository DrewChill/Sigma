package ml.kit.structs.impl.hdp;

import java.io.InputStream;

import ml.kit.cluster.Cluster;
import ml.kit.structs.group.Context;
import ml.kit.structs.group.Generator;

public class HDPGenerator<T> implements Generator<T>{

	@Override
	public Context<T> newContext(Cluster<T> parent) {
		HDPContext<T> context = new HDPContext<T>(parent.getLocalVocabulary());
		for(InputStream in : parent.groupStreams()) {
			context.createGroup(in);
		}
		return context;
	}

}
