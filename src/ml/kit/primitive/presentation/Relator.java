package ml.kit.primitive.presentation;

import ml.kit.primitive.read.Enumerator;
import ml.kit.primitive.str.strand;

public interface Relator<g,eg extends Enumerator<g>> extends strand<g,eg,g,eg> {

	Generator<g,eg> complex();

	Generator<g,eg> denominator();

}
