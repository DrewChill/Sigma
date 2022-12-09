package ml.kit.primitive.str;

import ml.kit.primitive.operator.Operator;

public interface character<g> {

	g kernel();

	<result> result read(Operator<g,result> options);

}
