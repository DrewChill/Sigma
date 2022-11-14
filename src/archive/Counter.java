package archive;

import ml.kit.primitive.num.AbstractNumber;
import ml.kit.primitive.num.Rational;
import ml.kit.primitive.num.measure.code.pkg.group.Action;
import ml.kit.primitive.num.measure.code.pkg.group.Group;

import java.util.Collection;
import java.util.Set;

public class Counter<point,domain extends Rational>
		implements
		Action<point,domain>,
		Group<point,domain,Counter<point,domain>>{



	//--------------------
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
	//--------------------



	//--------------------
	@Override
	public Collection<? extends point> sources() {
		return null;
	}
	@Override
	public point getPoint() {
		return null;
	}
	//-------
	@Override
	public Collection<? extends Counter<point,domain>> encoding() {
		return null;
	}
	@Override
	public Counter<point,domain> origin() {
		return null;
	}
	@Override
	public domain stabilizer() {
		return null;
	}
	//-------
	@Override
	public Collection<? extends Counter<point,domain>> targets() {
		return null;
	}
	@Override
	public Counter<point,domain> getDomain() {
		return null;
	}
	//--------------------



	//--------------------
	@Override
	public Set<Counter<point,domain>> include(point observation) {
		return null;
	}

	@Override
	public Set<Counter<point,domain>> exclude(point observation) {
		return null;
	}

	@Override
	public Set<Counter<point,domain>> fibersFromKey(point key) {
		return null;
	}
	//--------------------



	//--------------------
	@Override
	public Counter<point,domain> distance(Counter<point,domain> from, Counter<point,domain> to) {
		return null;
	}

	@Override
	public Counter<point,domain> length(Counter<point,domain> object) {
		return null;
	}
	//--------------------

}
