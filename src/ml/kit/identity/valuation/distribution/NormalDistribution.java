package ml.kit.identity.valuation.distribution;

import ml.kit.structs.dictionary.Entry;
import ml.kit.structs.measure.Norm;
import ml.kit.structs.num.Rational;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class NormalDistribution<T,M extends Number>
		extends Rational
		implements Norm<T,M>, Distribution<T,NormalDistribution<T,M>> {

	/* Note: will eventually want to update when new equivalents are added so that new cover
	         would be the sum of all equivalents (and be reflected in the number values)
	 */
	public T cover;

	public final T center;
	public final M denominator;

	private final Set<T> equivalents = new HashSet<>();

	public NormalDistribution(T center) {
		this(center,center);
	}

	public NormalDistribution(T center, T cover) {
		this.cover = cover;
		this.center = center;
		this.equivalents.add(cover);
		this.denominator = distance(center,center);
	}

	//------------------
	@Override
	public NormalDistribution<T,M> inc(T observation) {
		return null;
	}

	@Override
	public NormalDistribution<T,M> dec(T observation) {
		return null;
	}
	//------------------
	//------------------
	@Override
	public Set<T> sources() {
		return equivalents;
	}
	//------------------
	//------------------
	@Override
	public T center() {
		return center;
	}

	@Override
	public M denominator() {
		return denominator;
	}
	//------------------
	//------------------
	public M density(){
		return distance(center,cover);
	}

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
