package ml.kit.primitive.str;

import ml.kit.primitive.commutative.Transformation;

public interface Reader<g> {

	<result> result read(g obj, Transformation<g,result> translator);

}
