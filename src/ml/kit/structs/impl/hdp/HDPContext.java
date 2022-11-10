package ml.kit.structs.impl.hdp;

import java.io.InputStream;

import ml.kit.structs.asm.Observable;
import archive.Context;
import archive.AbstractEmitter;
import ml.kit.observer.AbstractObserver;

public class HDPContext<T extends Observable> extends Context<T> {
		
	public HDPContext(AbstractObserver<T> contextStructure) {
		super(contextStructure);
	}

	@Override
	public AbstractEmitter<T> createGroup(InputStream input) {
		AbstractEmitter<T> groupForInputStream = new HDPEmitter<T>(vocabulary);
		Thread groupThread = new Thread(groupForInputStream);
		groupThread.start();
		return groupForInputStream;
	}

	@Override
	protected AbstractEmitter<T> createGroup() {
		// TODO Auto-generated method stub
		return new HDPEmitter<T>(vocabulary);
	}

}
