package ml.kit.primitive.presentation;

import ml.kit.primitive.str.Enumerator;
import ml.kit.primitive.str.strand;

public interface Relator<g,ge extends Enumerator<g>> extends strand<g,ge,g,ge> {

	Generator<g,ge> complex();

	Generator<g,ge> denominator();

}
