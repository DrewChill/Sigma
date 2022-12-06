package ml.kit.primitive.presentation;

import ml.kit.primitive.num.number;

public interface Presentation<R,N extends number> {

	N present(R representation);

}
