package ml.kit.primitive.str;

import ml.kit.primitive.num.Rational;

public interface Str<g,h> extends Rational {

	g character();

	Str<h,?> complex();

}
