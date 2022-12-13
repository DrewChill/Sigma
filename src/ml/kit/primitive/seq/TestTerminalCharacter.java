package ml.kit.primitive.seq;

import ml.kit.primitive.operator.Op;

public class TestTerminalCharacter<g> implements TerminalCharacter<g> {

	@Override
	public g real() {
		return null;
	}

	@Override
	public <result> result read(Op<g,result> operator) {
		return null;
	}
}
