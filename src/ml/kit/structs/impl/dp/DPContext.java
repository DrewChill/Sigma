package ml.kit.structs.impl.dp;

import java.io.InputStream;

import ml.kit.structs.group.Context;
import ml.kit.structs.group.Synapse;
import ml.kit.symbol.generator.SymbolGenerator;

public class DPContext<T> extends Context<T>{

	public DPContext(SymbolGenerator<T> vocabulary) {
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
