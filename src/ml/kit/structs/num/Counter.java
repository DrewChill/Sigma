package ml.kit.structs.num;

import ml.kit.identity.valuation.distribution.Conjugate;
import ml.kit.identity.valuation.distribution.Distribution;

import java.util.Set;

public abstract class Counter<T,d extends Number>
		extends Distribution<T,d,Counter<T,d>>
		implements Conjugate<T,d>, Set<Counter<T,d>> {

	public Counter(T center) {
		super(center);
	}

	public Counter(T center, T cover) {
		super(center, cover);
	}

	@Override
	public d distance() {
		return distance(center,cover);
	}

	@Override
	public T getKey() {
		return center;
	}

}
