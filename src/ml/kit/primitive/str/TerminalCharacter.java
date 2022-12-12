package ml.kit.primitive.str;

import ml.kit.primitive.operator.Mapping;

public interface TerminalCharacter<g> {

	g real();

	<result> result read(Mapping<g,result> operator);

}
