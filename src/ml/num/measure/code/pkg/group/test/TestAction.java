package ml.num.measure.code.pkg.group.test;

import ml.num.Complex;
import ml.num.Rational;
import ml.num.measure.code.pkg.group.Action;
import ml.num.measure.code.pkg.group.Group;

public class TestAction<g,s extends Rational> implements Action<g,s> {

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
	public g getPoint() {
		return null;
	}
	@Override
	public s stabilizer() {
		return null;
	}
	@Override
	public Group<? extends g,?,? extends Action<? extends g,?>> getDomain() {
		return null;
	}

}