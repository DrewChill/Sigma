package ml.kit.primitive.commutator;

import ml.kit.primitive.construction.Generator;
import ml.kit.primitive.read.Reader;

public interface Commutator<g,rg extends Reader<g>,h,rh extends Reader<h>> extends Generator<g,rg> {

	Commutator<g,rg,h,rh> complex();

	Commutator<h,rh,g,rg> denominator();

}
