package ml.kit.structs.impl.dp;

import java.io.InputStream;

import ml.kit.cluster.Symbol;
import ml.kit.structs.group.Context;
import ml.kit.structs.group.Generator;

public class DPGenerator<T> implements Generator<T>{

	@Override
	public Context<T> newContext(Symbol<T> parent) {
		DPContext<T> context = new DPContext<T>(parent.getLocalVocabulary());
		for(InputStream in : parent.groupStreams()) {
			context.createGroup(in);
		}
		return context;
	}

}
