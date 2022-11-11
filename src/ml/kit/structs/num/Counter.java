package ml.kit.structs.num;

import ml.kit.identity.valuation.distribution.Conjugate;
import ml.kit.identity.valuation.distribution.Distribution;

import java.util.Set;

public abstract class Counter<T,d extends Rational>
		extends Distribution<T,d,Counter<T,d>>
		implements Conjugate<T,d>, Set<Counter<T,d>> {

}
