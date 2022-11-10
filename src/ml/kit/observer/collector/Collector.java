package ml.kit.observer.collector;

import ml.kit.identity.Identity;
import ml.kit.observer.emitter.Emitter;

public interface Collector<C,Unknown> extends Identity<Emitter<?,? extends C>, C, Unknown> {

	void onNext(C c);

	void onSubscribe(Emitter<?,? extends C> emitter);

	void onError(Throwable t);

	void onComplete();


}
