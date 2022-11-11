package ml.kit.structs.dictionary;

import ml.kit.structs.num.Rational;

public interface Path<K,V> extends Rational {

	K getKey();

	V getValue();

}
