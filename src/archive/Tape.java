package archive;

import ml.kit.primitive.operator.Operator;
import ml.kit.primitive.str.character;

public interface Tape<g,rg extends character<g>,h, rh extends character<h>> extends Strand<g,rg,h,rh> {

	Tape<h,rh,?,?> complex();

	default <observable> observable process(Operator<g,observable> observer){
		return lower().read(character(), observer);
	}

}
