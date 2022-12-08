package ml.kit.primitive.construction;

import ml.kit.primitive.operator.Operator;
import ml.kit.primitive.num.number;

public interface Presentation<R,N extends number> extends Operator<R,N> {

	N present(R representation);

}
