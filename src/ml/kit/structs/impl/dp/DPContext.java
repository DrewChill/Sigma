package ml.kit.structs.impl.dp;

import java.io.InputStream;

import ml.kit.structs.asm.MLObject;
import ml.kit.structs.group.Context;
import ml.kit.structs.group.Synapse;
import ml.kit.symbol.SymbolGenerator;

public class DPContext<T extends MLObject> extends Context<T>{

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
