package archive;

import ml.kit.primitive.operator.Operator;
import ml.kit.primitive.str.TerminalCharacter;

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
	public <result> result read(Operator<cg,result> operator) {
		return null;
	}
}
