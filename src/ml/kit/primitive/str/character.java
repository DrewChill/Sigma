package ml.kit.primitive.str;

import ml.kit.primitive.num.number;
import ml.kit.primitive.operator.Operator;

public interface character<g> extends number {

	g image();

	<result> result read(Operator<g,result> options);

}
