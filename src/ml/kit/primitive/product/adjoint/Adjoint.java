package ml.kit.primitive.product.adjoint;

import ml.kit.primitive.operator.Mapping;
import ml.kit.primitive.seq.InitialCharacter;
import ml.kit.primitive.seq.TerminalCharacter;

public interface Adjoint<g,h,ch extends TerminalCharacter<h>> extends InitialCharacter<g,h,ch> {

	Mapping<g,ch> adjunction();

	@Override
	default ch complex(){
		return read(adjunction());
	}

}
