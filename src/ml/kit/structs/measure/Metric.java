package ml.kit.structs.measure;

import ml.kit.structs.num.Rational;

public interface Metric<T,d extends Rational> extends Rational {

	//aka 0, aka center
	T origin();

	d distance(T from, T to);

	default d length(T object){
		return distance(origin(),object);
	}

}
