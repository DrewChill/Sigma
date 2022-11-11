package ml.kit.structs.num;

import ml.kit.identity.valuation.distribution.Conjugate;
import ml.kit.identity.valuation.distribution.Distribution;

import java.util.Collection;

public class Counter<T,d extends Number>
		extends Distribution<T,d,Counter<T,d>>
		implements Conjugate<T,d>, Count<T,d> {


	public Counter(T center) {
		super(center);
	}

	@Override
	public Counter<T,d> inc(T observation) {
		return null;
	}

	@Override
	public Counter<T,d> dec(T observation) {
		return null;
	}


	@Override
	public Collection<? extends T> sources() {
		return null;
	}

	@Override
	public Counter<T,d> targets() {
		return null;
	}

	@Override
	public d distance() {
		return null;
	}

	@Override
	public Counter<T,d> element() {
		return null;
	}

	@Override
	public Counter<T,d> entriesFromKey(T key) {
		return null;
	}

	@Override
	public T getKey() {
		return null;
	}

	@Override
	public Counter<T,d> getValue() {
		return null;
	}

	@Override
	public d distance(T from, T to) {
		return null;
	}
}
