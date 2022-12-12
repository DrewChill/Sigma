package ml.kit.primitive.chiral.adjoint;

import ml.kit.primitive.chiral.Right;
import ml.kit.primitive.str.AdjointCharacter;
import ml.kit.primitive.str.TerminalCharacter;

public interface RightAdjunction<right,adjoint,ca extends TerminalCharacter<adjoint>> extends Right<right> {

	@Override
	AdjointCharacter<right,adjoint,ca> getRight();

}
