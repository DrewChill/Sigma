package ml.kit.structs.impl;

import java.io.InputStream;
import java.io.Serializable;

import ml.kit.structs.group.Context;
import ml.kit.structs.group.Synapse;
import ml.kit.symbol.generator.SymbolGenerator;

public class BaseContext<T extends Serializable> extends Context<T> {
	
	public BaseContext(SymbolGenerator<T> vocabulary) {
		super(vocabulary);
	}

	@Override
	public Synapse<T> createGroup(InputStream input) {
		Synapse<T> groupForInputStream = new BaseGroup<T>(vocabulary);
		Thread groupThread = new Thread(groupForInputStream);
		groupThread.start();
		return groupForInputStream;
	}

}
