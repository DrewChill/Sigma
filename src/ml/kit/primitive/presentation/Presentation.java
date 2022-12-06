package ml.kit.primitive.presentation;

import ml.kit.primitive.num.Num;

public interface Presentation<R,N extends Num> {

	N present(R representation);

}
