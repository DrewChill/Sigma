package ml.kit.primitive.str;

import ml.kit.primitive.operator.Operator;

public interface AdjointCharacter<g,h,ch extends TerminalCharacter<h>> extends InitialCharacter<g,h,ch> {

	Operator<g,ch> adjunction();

	@Override
	default ch complex(){
		return read(adjunction());
	}

}
