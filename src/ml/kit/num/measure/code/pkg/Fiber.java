package ml.kit.num.measure.code.pkg;

import ml.kit.num.Rational;

public interface Fiber<P,D> extends Rational {

	P getPoint();

	D getDomain();

}
