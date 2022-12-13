package ml.kit.primitive.num.measure.code.pkg.group.test;

import ml.kit.primitive.num.Complex;
import ml.kit.primitive.num.Rational;
import ml.kit.primitive.num.measure.code.Code;
import ml.kit.primitive.num.measure.code.pkg.group.Group;
import ml.kit.primitive.num.measure.code.pkg.group.Action;

import java.util.Collection;
import java.util.Set;

public class Weird<point,domain extends Rational>
		implements
		Group<point,domain,Weird<point,domain>>, Action<point,domain> {

	@Override
	public Number character() {
		return null;
	}

	@Override
	public Complex root() {
		return null;
	}

	@Override
	public Complex denominator() {
		return null;
	}

	@Override
	public Weird<point,domain> origin() {
		return null;
	}

	@Override
	public Code<point,Weird<point,domain>,Group<? extends point,?,? extends Action<? extends point,?>>> distance(Weird<point,domain> from, Weird<point,domain> to) {
		return null;
	}

	@Override
	public Collection<? extends point> sources() {
		return null;
	}

	@Override
	public Collection<? extends Weird<point,domain>> encoding() {
		return null;
	}

	@Override
	public Collection<? extends Group<? extends point,?,? extends Action<? extends point,?>>> targets() {
		return null;
	}

	@Override
	public Set<Weird<point,domain>> fibersFromKey(point key) {
		return null;
	}

	@Override
	public point getPoint() {
		return null;
	}

	@Override
	public Group<? extends point,?,? extends Action<? extends point,?>> getDomain() {
		return null;
	}

	@Override
	public domain stabilizer() {
		return null;
	}

	@Override
	public Set<? extends Group<? extends point,?,? extends Action<? extends point,?>>> include(point observation) {
		return null;
	}

	@Override
	public Set<? extends Group<? extends point,?,? extends Action<? extends point,?>>> exclude(point observation) {
		return null;
	}
}
