package ml.kit.reactive;

public interface Subscription {

	void request(long n);

	void cancel();

}
