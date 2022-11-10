package ml.kit.identity.valuation.distribution;

import ml.kit.structs.dictionary.Entry;

public interface Conjugate<T,d extends Number> extends Entry<T,Distribution<T,? extends d>> {

	d distance();

}
