package ml.kit.primitive.chiral.adjoint;

import ml.kit.primitive.chiral.Left;
import ml.kit.primitive.str.AdjointCharacter;
import ml.kit.primitive.str.TerminalCharacter;

public interface LeftAdjunction<left,adjoint,ca extends TerminalCharacter<adjoint>> extends Left<left> {

	@Override
	AdjointCharacter<left,adjoint,ca> getLeft();

}
