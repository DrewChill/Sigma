package ml.kit.primitive.product.adjoint;

import ml.kit.primitive.operator.Op;
import archive.InitCharacter;
import ml.kit.primitive.seq.TerminalCharacter;

public interface Adjoint<g,h,ch extends TerminalCharacter<h>> extends InitCharacter<g,h,ch> {

	Op<g,ch> adjunction();

	@Override
	default ch complex(){
		return read(adjunction());
	}

}
