package ml.kit.primitive;

import ml.kit.primitive.operator.Op;

public interface Something<c> extends Nothing {

	c real();

	<result> result read(Op<c,result> operator);

}
