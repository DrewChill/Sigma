package archive;

import ml.kit.primitive.operator.combinator.Combinator;
import ml.kit.primitive.seq.OperationalCharacter;
import ml.kit.primitive.seq.TerminalCharacter;

public interface InitCharacter<g,h,ch extends TerminalCharacter<h>> extends OperationalCharacter<g,h> {

	@Override
	ch complex();

	default <result> result read(Combinator<g,h,ch,result> combinator){
		return combinator.operate(complex()).operate(real());
	}

}
