package ml.kit.primitive.construction;

import ml.kit.primitive.read.Enumerator;
import ml.kit.primitive.str.Strand;

public interface Relator<g,eg extends Enumerator<g>>
		extends Strand<Generator<g,eg>,Generator<g,eg>,Generator<g,eg>,Generator<g,eg>> {

	Relator<g,eg> complex();

}
