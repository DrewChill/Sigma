package ml.kit.primitive.operator.construction;

import ml.kit.primitive.operator.Mapping;
import ml.kit.primitive.num.Complex;

public interface Representation<N extends Complex,R> extends Mapping<N,R> {

	R represent(N num);

}
