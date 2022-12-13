package ml.kit.primitive.product.relation.construction;

import ml.kit.primitive.product.relation.Op;
import ml.kit.primitive.num.Complex;

public interface Presentation<R,N extends Complex> extends Op<R,N> {

	N present(R representation);

}
