package ml.kit.primitive.commutative;

import ml.kit.primitive.chiral.Left;
import ml.kit.primitive.chiral.Right;
import ml.kit.primitive.presentation.Relator;

public interface Transformation<g,h> {

	<c extends Right<g> & Left<h>> Relator<c> transform(Commutator<g,h> commutator);

}
