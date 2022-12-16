package ml.kit.observer.emitter;

import ml.kit.num.measure.code.Code;
import ml.kit.observer.collector.Collector;

import java.util.Collection;
import java.util.Queue;

public interface Emitter<Unknown,E> extends Code<Unknown, E, Collector<? super E,?>> {

	Queue<E> dataBuffer();

	void subscribe(Collector<? super E,?> collector);

	default void addData(E item) {
		synchronized(dataBuffer()) {
			dataBuffer().add(item);
			dataBuffer().notify();
		}
	}

	default void addData(Collection<E> items) {
		synchronized(dataBuffer()) {
			for(E item : items){
				addData(item);
			}
		}
	}

	default void run() {
		while (true) {
			E data;
			synchronized(dataBuffer()) {
				if (dataBuffer().isEmpty()) {
					try {
						//System.out.println("waiting for data...");
						dataBuffer().wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//System.out.println("decoding data...");
				data = dataBuffer().poll();
				if(data != null){
					for(Collector<? super E,?> path : targets()){
						path.onNext(data);
					}
				}
			}
		}
	}

}
