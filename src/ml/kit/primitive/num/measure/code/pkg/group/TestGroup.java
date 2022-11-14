package ml.kit.primitive.num.measure.code.pkg.group;

import ml.kit.primitive.num.measure.code.Code;
import ml.kit.primitive.num.AbstractNumber;
import ml.kit.primitive.num.Rational;

import java.util.Collection;
import java.util.Set;

public class TestGroup<g,s extends Rational,A extends Action<g,s>> implements Group<g,s,A> {
	@Override
	public Collection<? extends g> sources() {
		return null;
	}

	@Override
	public Collection<? extends A> encoding() {
		return null;
	}

	@Override
	public Collection<? extends Group<? extends g,?,? extends Action<? extends g,?>>> targets() {
		return null;
	}

	@Override
	public Set<? extends Group<? extends g,?,? extends Action<? extends g,?>>> include(g observation) {
		return null;
	}

	@Override
	public Set<? extends Group<? extends g,?,? extends Action<? extends g,?>>> exclude(g observation) {
		return null;
	}

	@Override
	public Code<g,A,Group<? extends g,?,? extends Action<? extends g,?>>> distance(A from, A to) {
		return null;
	}

	@Override
	public Set<A> fibersFromKey(g key) {
		return null;
	}

	@Override
	public A origin() {
		return null;
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

}
