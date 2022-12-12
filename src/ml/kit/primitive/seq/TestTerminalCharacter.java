package ml.kit.primitive.seq;

import ml.kit.primitive.operator.Mapping;

public class TestTerminalCharacter<g> implements TerminalCharacter<g> {

	@Override
	public g real() {
		return null;
	}

	@Override
	public <result> result read(Mapping<g,result> operator) {
		return null;
	}
}
