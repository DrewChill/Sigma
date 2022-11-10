package ml.kit.identity.valuation.distribution;

import ml.kit.structs.dictionary.Dictionary;

public interface Distribution
		<T,D extends Distribution<T,?>> extends Dictionary<T,D,Conjugate<T,D>> {

	D inc(T observation);

	D dec(T observation);

}
