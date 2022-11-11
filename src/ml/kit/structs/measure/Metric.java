package ml.kit.structs.measure;

import ml.kit.structs.num.Rational;

public interface Metric<T,d extends Rational> extends Rational {

	//aka 0, aka origin, aka center
	T stabilizer();

	d distance(T from, T to);

	default d length(T object){
		return distance(stabilizer(),object);
	}

}
