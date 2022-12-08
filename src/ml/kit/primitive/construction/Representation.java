package ml.kit.primitive.construction;

import ml.kit.primitive.operator.Operator;
import ml.kit.primitive.num.number;

public interface Representation<N extends number,R> extends Operator<N,R> {

	R represent(N num);

}
