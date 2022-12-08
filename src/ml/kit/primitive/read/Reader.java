package ml.kit.primitive.read;

import ml.kit.primitive.Operator.Operator;

public interface Reader<g> {

	<result> result read(g obj, Operator<g,result> options);

}
