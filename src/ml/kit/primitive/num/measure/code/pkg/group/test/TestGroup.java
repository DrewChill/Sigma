package ml.kit.primitive.num.measure.code.pkg.group.test;

import ml.kit.primitive.num.Complex;
import ml.kit.primitive.num.Rational;
import ml.kit.primitive.num.measure.code.Code;
import ml.kit.primitive.num.measure.code.pkg.group.Group;
import ml.kit.primitive.num.measure.code.pkg.group.Action;

import java.util.Collection;
import java.util.Set;

public class TestGroup<g,s extends Rational> implements Group<g,s,TestAction<g,s>> {

	@Override
	public Number real() {
		return null;
	}
	@Override
	public Complex complex() {
		return null;
	}
	@Override
	public Complex denominator() {
		return null;
	}


	@Override
	public TestAction<g,s> origin() {
		return null;
	}

	@Override
	public Code<g,TestAction<g,s>,Group<? extends g,?,? extends Action<? extends g,?>>> distance(TestAction<g,s> from, TestAction<g,s> to) {
		return null;
	}

	@Override
	public Collection<? extends g> sources() {
		return null;
	}

	@Override
	public Collection<? extends TestAction<g,s>> encoding() {
		return null;
	}

	@Override
	public Collection<? extends Group<? extends g,?,? extends Action<? extends g,?>>> targets() {
		return null;
	}

	@Override
	public Set<TestAction<g,s>> fibersFromKey(g key) {
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
}
