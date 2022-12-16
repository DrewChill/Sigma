package archive;

import ml.num.measure.code.Code;
import ml.num.Complex;
import ml.num.Rational;
import ml.num.measure.code.pkg.group.Action;
import ml.num.measure.code.pkg.group.Group;

import java.util.Collection;
import java.util.Set;

public class TestGroup<g,s extends Rational,A extends Action<g,s>> implements ml.num.measure.code.pkg.group.Group<g,s,A> {
	@Override
	public Collection<? extends g> sources() {
		return null;
	}

	@Override
	public Collection<? extends A> encoding() {
		return null;
	}

	@Override
	public Collection<? extends ml.num.measure.code.pkg.group.Group<? extends g,?,? extends Action<? extends g,?>>> targets() {
		return null;
	}

	@Override
	public Set<? extends ml.num.measure.code.pkg.group.Group<? extends g,?,? extends Action<? extends g,?>>> include(g observation) {
		return null;
	}

	@Override
	public Set<? extends ml.num.measure.code.pkg.group.Group<? extends g,?,? extends Action<? extends g,?>>> exclude(g observation) {
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

}
