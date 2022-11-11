package archive.grpcontext.dp;

import java.io.InputStream;

import archive.asm.Observable;
import archive.Context;
import archive.AbstractEmitter;
import ml.kit.observer.AbstractObserver;

public class DPContext<T extends Observable> extends Context<T>{

	public DPContext(AbstractObserver<T> contextStructure) {
		super(contextStructure);
	}

	@Override
	public AbstractEmitter<T> createGroup(InputStream input) {
		AbstractEmitter<T> groupForInputStream = new DPEmitter<T>(vocabulary);
		Thread groupThread = new Thread(groupForInputStream);
		groupThread.start();
		return groupForInputStream;
	}

	@Override
	protected AbstractEmitter<T> createGroup() {
		return new DPEmitter<T>(vocabulary);
	}

}
