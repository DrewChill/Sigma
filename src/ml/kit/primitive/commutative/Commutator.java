package ml.kit.primitive.commutative;

import ml.kit.primitive.presentation.Generator;

public interface Commutator<g,h> extends Generator<g> {

	Commutator<g,h> complex();

	Commutator<h,g> denominator();

}
