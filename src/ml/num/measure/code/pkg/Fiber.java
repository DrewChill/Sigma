package ml.num.measure.code.pkg;

import ml.num.Rational;

public interface Fiber<P,D> extends Rational {

	P getPoint();

	D getDomain();

}
