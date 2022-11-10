package ml.kit.reactive;

public interface Publisher<T> extends Runnable {

	void subscribe(Subscriber<? super T> s);

}

