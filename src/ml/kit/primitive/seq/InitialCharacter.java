package ml.kit.primitive.seq;

import ml.kit.primitive.operator.combinator.Combinator;

public interface InitialCharacter<g,h,ch extends TerminalCharacter<h>> extends InitialTerminalCharacter<g,h> {

	@Override
	ch complex();

	default <result> result read(Combinator<g,h,ch,result> combinator){
		return combinator.operate(complex()).operate(real());
	}

}
