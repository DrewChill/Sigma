package ml.kit.primitive.num.measure.code.pkg.group.test;

import ml.kit.primitive.num.number;
import ml.kit.primitive.num.Rational;
import ml.kit.primitive.num.measure.code.pkg.group.Action;
import ml.kit.primitive.num.measure.code.pkg.group.Group;

public class TestAction<g,s extends Rational> implements Action<g,s> {

	@Override
	public Number real() {
		return null;
	}
	@Override
	public number complex() {
		return null;
	}
	@Override
	public number denominator() {
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