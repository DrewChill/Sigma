package ml.kit.identity.valuation.distribution;

import ml.kit.identity.Identity;
import ml.kit.structs.dictionary.Bundle;
import ml.kit.structs.num.AbstractNumber;
import ml.kit.structs.num.Rational;

import java.util.Collection;
import java.util.Set;

//I'm gonna throw up
public abstract class Distribution<T,d extends Rational,C extends Conjugate<T,d>>
		implements
		Bundle<
				T,
				Distribution<
						? extends T,
						? extends d,
						? extends Conjugate<? extends T,? extends d>>,
				C> {


	//------------------
	public abstract Set<
			? extends Distribution<
					T,
					? extends d,
					? extends Conjugate<T,? extends d>>> inc(T observation);

	public abstract Set<
			? extends Distribution<
				T,
				? extends d,
				? extends Conjugate<T,? extends d>>> dec(T observation);

	@Override
	public Collection<? extends T> sources() {
		return null;
	}

	@Override
	public Collection<C> encoding() {
		return null;
	}

	@Override
	public Collection<? extends
			Distribution<
					? extends T,
					? extends d,
					? extends Conjugate<? extends T,? extends d>>> targets() {
		return null;
	}

	@Override
	public Set<C> fibersFromKey(T key) {
		return null;
	}

	@Override
	public C stabilizer() {
		return null;
	}

	@Override
	public Identity<T,C,Distribution<? extends T,? extends d,? extends Conjugate<? extends T,? extends d>>> distance(C from, C to) {
		return null;
	}

	@Override
	public Identity<T,C,Distribution<? extends T,? extends d,? extends Conjugate<? extends T,? extends d>>> length(C object) {
		return Bundle.super.length(object);
	}


	@Override
	public Number value() {
		return null;
	}

	@Override
	public AbstractNumber real() {
		return null;
	}

	@Override
	public AbstractNumber denominator() {
		return null;
	}
	//------------------

	//sources contains the set of orbits, this is the union(/convolution?) of them all
//	public abstract T orbit();
//
//
//	public d density() {
//		return length(orbit());
//	}

}

//	@Override
//	public int intValue() {
//		return stabilizer().intValue() - denominator().intValue();
//	}
//
//	@Override
//	public long longValue() {
//		return stabilizer().longValue() - denominator().longValue();
//	}
//
//	@Override
//	public float floatValue() {
//		return stabilizer().floatValue() - denominator().floatValue();
//	}
//
//	@Override
//	public double doubleValue() {
//		return stabilizer().doubleValue() - denominator().doubleValue();
//	}
