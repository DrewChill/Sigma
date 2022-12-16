package ml.observer;

import ml.observer.emitter.Emitter;
import ml.observer.collector.Collector;

import java.util.Collection;

//effectively implements Identity< Emitter<?,? extends Input>, Sensor<? super Output,?> >
public abstract class Observer<Input,Output> implements
		Collector<Input,Collector<? super Output,?>>,
		Emitter<Emitter<?,? extends Input>, Output>{

	@Override
	public abstract Collection<Emitter<?,? extends Input>> sources();

	@Override
	public abstract Collection<Collector<? super Output,?>> targets();

}
