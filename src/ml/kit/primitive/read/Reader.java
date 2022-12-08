package ml.kit.primitive.read;

import ml.kit.primitive.operator.Operator;

public interface Reader<g> {

	<result> result read(g obj, Operator<g,result> options);

}
