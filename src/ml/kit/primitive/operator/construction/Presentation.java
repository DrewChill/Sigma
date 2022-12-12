package ml.kit.primitive.operator.construction;

import ml.kit.primitive.operator.Mapping;
import ml.kit.primitive.num.Complex;

public interface Presentation<R,N extends Complex> extends Mapping<R,N> {

	N present(R representation);

}
