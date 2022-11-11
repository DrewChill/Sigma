package ml.kit.identity.valuation.distribution;

import ml.kit.structs.dictionary.Dictionary;
import ml.kit.structs.measure.Norm;
import ml.kit.structs.num.Rational;

import java.util.Set;

//I'm gonna throw up
public abstract class Distribution<T,d extends Number,C extends Conjugate<T,d>>
		extends
		Rational
		implements
		Norm<T,d>,
		Dictionary<
				T,
				Distribution<
						? extends T,
						? extends d,
						? extends Conjugate<T,? extends d>>,
				C> {

	/* Note: will eventually want to update when new equivalents are added so that new cover
	         would be the sum of all equivalents (and be reflected in the number values)
	 */
	public T cover;

	public final T center;
	public final d denominator;

	public Distribution(T center) {
		this(center,center);
	}

	public Distribution(T center, T cover) {
		this.cover = cover;
		this.center = center;
		this.denominator = distance(center,center);
	}

	//------------------
	public abstract Set<? extends Distribution<
			T,
			? extends d,
			? extends Conjugate<T,? extends d>>> inc(T observation);

	public abstract Set<? extends Distribution<
			T,
			? extends d,
			? extends Conjugate<T,? extends d>>> dec(T observation);
	//------------------
	//------------------
	public abstract T orbit();

	@Override
	public abstract T stabilizer();

	public d density(){
		return distance(center,cover);
	}

	@Override
	public d denominator() {
		return distance(center,center);
	}
	//------------------
	//------------------
	@Override
	public int intValue() {
		return density().intValue() - denominator.intValue();
	}

	@Override
	public long longValue() {
		return density().longValue() - denominator.longValue();
	}

	@Override
	public float floatValue() {
		return density().floatValue() - denominator.floatValue();
	}

	@Override
	public double doubleValue() {
		return density().doubleValue() - denominator.doubleValue();
	}

	@Override
	public int compare(T o1, T o2) {
		return distance(center,o1).intValue() - distance(center,o2).intValue();
	}
	//------------------

}
