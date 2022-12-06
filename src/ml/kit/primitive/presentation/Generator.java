package ml.kit.primitive.presentation;

import ml.kit.primitive.num.Num;

public interface Generator<g> extends Num {

	g letter();

	Generator<g> complex();

}
