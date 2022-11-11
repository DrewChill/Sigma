package ml.kit.identity.valuation.distribution;

import ml.kit.structs.dictionary.Path;
import ml.kit.structs.num.Rational;

public interface Conjugate<T,d extends Rational>
		extends Path<
				T,
				Distribution<
						? extends T,
						? extends d,
						? extends Conjugate<? extends T,? extends d>>> {

	d distance();

}
