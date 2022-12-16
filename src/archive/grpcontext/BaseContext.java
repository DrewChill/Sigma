package archive.grpcontext;

import java.io.InputStream;

import archive.asm.Observable;
import archive.Context;
import archive.AbstractEmitter;
import ml.observer.AbstractObserver;

public class BaseContext<T extends Observable> extends Context<T> {
	
	public BaseContext(AbstractObserver<T> contextStructure) {
		super(contextStructure);
	}

	@Override
	public AbstractEmitter<T> createGroup(InputStream input) {
		AbstractEmitter<T> groupForInputStream = new BaseGroup<T>(vocabulary);
		Thread groupThread = new Thread(groupForInputStream);
		groupThread.start();
		return groupForInputStream;
	}

	@Override
	protected AbstractEmitter<T> createGroup() {
		return new BaseGroup<T>(vocabulary);
	}

}
