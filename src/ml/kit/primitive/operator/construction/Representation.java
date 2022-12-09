package ml.kit.primitive.operator.construction;

import ml.kit.primitive.operator.Operator;
import ml.kit.primitive.num.Complex;

public interface Representation<N extends Complex,R> extends Operator<N,R> {

	R represent(N num);

}
