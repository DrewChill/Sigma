package ml.kit.structs.impl;

import java.io.InputStream;

import ml.kit.structs.asm.MLObject;
import ml.kit.structs.group.Context;
import ml.kit.structs.group.Synapse;
import ml.kit.symbol.structure.StructureInfo;

public class BaseContext<T extends MLObject> extends Context<T> {
	
	public BaseContext(StructureInfo<T> contextStructure) {
		super(contextStructure);
	}

	@Override
	public Synapse<T> createGroup(InputStream input) {
		Synapse<T> groupForInputStream = new BaseGroup<T>(vocabulary);
		Thread groupThread = new Thread(groupForInputStream);
		groupThread.start();
		return groupForInputStream;
	}

	@Override
	protected Synapse<T> createGroup() {
		// TODO Auto-generated method stub
		return new BaseGroup<T>(vocabulary);
	}

}
