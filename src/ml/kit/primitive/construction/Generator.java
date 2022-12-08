package ml.kit.primitive.construction;

import ml.kit.primitive.read.Reader;
import ml.kit.primitive.str.Tape;

public interface Generator<g,rg extends Reader<g>> extends Tape<g,rg,g,rg> {

	Generator<g,rg> complex();

}
