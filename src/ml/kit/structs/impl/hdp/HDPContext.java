package ml.kit.structs.impl.hdp;

import java.io.InputStream;

import ml.kit.structs.group.Context;
import ml.kit.structs.group.Synapse;
import ml.kit.symbol.SymbolGenerator;

public class HDPContext<T> extends Context<T> {
		
	public HDPContext(SymbolGenerator<T> vocabulary) {
		super(vocabulary);
	}

	@Override
	public Synapse<T> createGroup(InputStream input) {
		Synapse<T> groupForInputStream = new FeedbackSynapse<T>(vocabulary);
		Thread groupThread = new Thread(groupForInputStream);
		groupThread.start();
		return groupForInputStream;
	}

}
