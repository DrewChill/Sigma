package ml.kit.primitive.str;

import ml.kit.primitive.operator.Operator;

public class TestTerminalCharacter<g> implements TerminalCharacter<g> {

	@Override
	public g real() {
		return null;
	}

	@Override
	public <result> result read(Operator<g,result> operator) {
		return null;
	}
}
