package archive;

import archive.relation.Op;
import ml.kit.primitive.seq.TerminalCharacter;

public class TestStringNode<g,cg extends TerminalCharacter<g>> implements StringNode<g,cg> {

	@Override
	public cg character() {
		return null;
	}

	@Override
	public StringNode<g,cg> nextNode() {
		return null;
	}

	@Override
	public <result> result read(Op<cg,result> operator) {
		return null;
	}
}
