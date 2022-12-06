package ml.kit.primitive.representation;

import ml.kit.primitive.num.Num;

public interface Representation<N extends Num,R> {

	R represent(N num);

}
