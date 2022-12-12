package ml.kit.primitive.str;

import ml.kit.primitive.operator.combinator.Terminator;

public interface InitialTerminalCharacter<g,h> extends TerminalCharacter<g> {

	TerminalCharacter<h> complex();

	default <result> result read(Terminator<g,h,result> terminator){
		return terminator.operate(complex()).operate(real());
	}

}
