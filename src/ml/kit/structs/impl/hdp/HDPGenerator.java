package ml.kit.structs.impl.hdp;

import java.io.InputStream;

import ml.kit.structs.group.Context;
import ml.kit.structs.group.Generator;
import ml.kit.symbol.Symbol;

public class HDPGenerator<T> implements Generator<T>{

	@Override
	public Context<T> newContext(Symbol<T> parent) {
		HDPContext<T> context = new HDPContext<T>(parent.getLocalVocabulary());
		for(InputStream in : parent.groupStreams()) {
			context.createGroup(in);
		}
		return context;
	}

}
