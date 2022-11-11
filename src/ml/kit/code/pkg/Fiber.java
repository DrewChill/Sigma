package ml.kit.code.pkg;

import ml.kit.primitive.num.Rational;

public interface Fiber<K,V> extends Rational {

	K getKey();

	V getValue();

}
