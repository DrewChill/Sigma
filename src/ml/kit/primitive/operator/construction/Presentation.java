package ml.kit.primitive.operator.construction;

import ml.kit.primitive.operator.Op;
import ml.kit.primitive.num.Complex;

public interface Presentation<R,N extends Complex> extends Op<R,N> {

	N present(R representation);

}
