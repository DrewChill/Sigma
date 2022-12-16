package ml.reactive;

public interface Subscription {

	void request(long n);

	void cancel();

}
