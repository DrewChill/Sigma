package ml.kit.primitive.operator.construction;

import ml.kit.primitive.operator.Op;
import ml.kit.primitive.num.Complex;

public interface Representation<N extends Complex,R> extends Op<N,R> {

	R represent(N num);

}
