package archive;

import ml.kit.primitive.operator.Mapping;
import ml.kit.primitive.seq.TerminalCharacter;

public class TestStringNode<g,cg extends TerminalCharacter<g>> implements StringNode<g,cg> {

	@Override
	public cg real() {
		return null;
	}

	@Override
	public StringNode<g,cg> nextNode() {
		return null;
	}

	@Override
	public <result> result read(Mapping<cg,result> operator) {
		return null;
	}
}
