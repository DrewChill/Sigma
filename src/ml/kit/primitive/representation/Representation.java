package ml.kit.primitive.representation;

import ml.kit.primitive.num.number;

public interface Representation<N extends number,R> {

	R represent(N num);

}
