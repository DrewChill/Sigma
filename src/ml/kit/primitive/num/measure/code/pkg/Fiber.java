package ml.kit.primitive.num.measure.code.pkg;

import ml.kit.primitive.num.Rational;

public interface Fiber<P,D> extends Rational {

	P getPoint();

	D getDomain();

}
