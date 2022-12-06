package ml.kit.primitive.presentation;

import ml.kit.primitive.num.Rational;

public interface Relator<g> extends Rational {

	Generator<g> complex();

	Generator<g> denominator();

}
