package ml.kit.primitive.str;

import ml.kit.primitive.operator.Mapping;

public interface AdjointCharacter<g,h,ch extends TerminalCharacter<h>> extends InitialCharacter<g,h,ch> {

	Mapping<g,ch> adjunction();

	@Override
	default ch complex(){
		return read(adjunction());
	}

}
