package ml.kit.primitive.read;

import ml.kit.primitive.num.number;
import ml.kit.primitive.operator.Operator;

public interface Reader<g> extends number {

	<result> result read(g obj, Operator<g,result> options);

}
