package ml.kit.primitive.str;

import ml.kit.primitive.operator.Operator;
import ml.kit.primitive.read.Reader;

public interface Tape<g,rg extends Reader<g>,h, rh extends Reader<h>> extends Strand<g,rg,h,rh> {

	Tape<h,rh,?,?> complex();

	default <observable> observable process(Operator<g,observable> observer){
		return lower().read(character(), observer);
	}

}
