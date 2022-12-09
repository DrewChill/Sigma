package ml.kit.primitive.operator.construction;

import ml.kit.primitive.operator.Operator;
import ml.kit.primitive.num.Complex;

public interface Presentation<R,N extends Complex> extends Operator<R,N> {

	N present(R representation);

}
