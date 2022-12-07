package ml.kit.primitive.presentation;

import ml.kit.primitive.read.Reader;
import ml.kit.primitive.str.string;

public interface Generator<g,rg extends Reader<g>> extends string<g,rg,g,rg> {

	Generator<g,rg> complex();

}
