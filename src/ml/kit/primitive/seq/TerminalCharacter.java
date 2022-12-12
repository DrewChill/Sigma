package ml.kit.primitive.seq;

import ml.kit.primitive.operator.Mapping;

public interface TerminalCharacter<g> {

	g real();

	<result> result read(Mapping<g,result> operator);

}
