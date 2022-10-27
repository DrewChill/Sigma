package ml.kit.structs.impl;

import java.io.InputStream;

import ml.kit.structs.asm.MLObject;
import ml.kit.structs.group.Context;
import ml.kit.structs.group.Intraface;
import ml.kit.observer.Observer;

public class BaseContext<T extends MLObject> extends Context<T> {
	
	public BaseContext(Observer<T> contextStructure) {
		super(contextStructure);
	}

	@Override
	public Intraface<T> createGroup(InputStream input) {
		Intraface<T> groupForInputStream = new BaseGroup<T>(vocabulary);
		Thread groupThread = new Thread(groupForInputStream);
		groupThread.start();
		return groupForInputStream;
	}

	@Override
	protected Intraface<T> createGroup() {
		return new BaseGroup<T>(vocabulary);
	}

}
