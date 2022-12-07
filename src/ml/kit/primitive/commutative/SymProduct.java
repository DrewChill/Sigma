package ml.kit.primitive.commutative;

import ml.kit.primitive.chiral.Left;
import ml.kit.primitive.chiral.Right;
import ml.kit.primitive.presentation.Relator;
import ml.kit.primitive.read.Enumerator;
import ml.kit.primitive.read.Reader;

public interface SymProduct<g,rg extends Reader<g>,h,rh extends Reader<h>> {

	SymProduct<h,rh,g,rg> flip();

	<c extends Right<g> & Left<h>,
			ec extends Enumerator<c>> Relator<c,ec> transform(Commutator<g,rg,h,rh> commutator);

}
