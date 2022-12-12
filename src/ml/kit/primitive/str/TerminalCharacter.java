package ml.kit.primitive.str;

import ml.kit.primitive.operator.Operator;

public interface TerminalCharacter<g> {

	g real();

	<result> result read(Operator<g,result> operator);

}
