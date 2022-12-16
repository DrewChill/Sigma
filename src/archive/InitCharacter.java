package archive;

import archive.relation.combinator.Combinator;
import ml.foundation.primitive.seq.TransformationCharacter;
import ml.foundation.primitive.seq.TerminalCharacter;

public interface InitCharacter<g,h,ch extends TerminalCharacter<h>> extends TransformationCharacter<g,h> {

	@Override
	ch root();

	default <result> result read(Combinator<g,h,ch,result> combinator){
		return combinator.operate(this.root()).operate(character());
	}

}
