package archive;

import ml.kit.primitive.product.relation.combinator.Combinator;
import ml.kit.primitive.seq.TransformationCharacter;
import ml.kit.primitive.seq.TerminalCharacter;

public interface InitCharacter<g,h,ch extends TerminalCharacter<h>> extends TransformationCharacter<g,h> {

	@Override
	ch root();

	default <result> result read(Combinator<g,h,ch,result> combinator){
		return combinator.operate(this.root()).operate(character());
	}

}
