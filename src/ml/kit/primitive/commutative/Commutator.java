package ml.kit.primitive.commutative;

import ml.kit.primitive.presentation.Generator;
import ml.kit.primitive.str.Reader;

public interface Commutator<g,rg extends Reader<g>,h,rh extends Reader<h>> extends Generator<g,rg> {

	Commutator<g,rg,h,rh> complex();

	Commutator<h,rh,g,rg> denominator();

}
