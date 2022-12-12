package ml.kit.primitive.product.adjoint;

import ml.kit.primitive.product.Right;
import ml.kit.primitive.str.AdjointCharacter;
import ml.kit.primitive.str.TerminalCharacter;

public interface RightAdjunction<right,adjoint,ca extends TerminalCharacter<adjoint>> extends Right<right> {

	@Override
	AdjointCharacter<right,adjoint,ca> getRight();

}
