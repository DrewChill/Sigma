package ml.kit.primitive.operator.construction.composition;

import ml.kit.primitive.num.Complex;
import ml.kit.primitive.operator.construction.Presentation;
import ml.kit.primitive.operator.construction.Representation;
import ml.kit.primitive.operator.Mapping;

public interface Functor<g,N extends Complex,h> extends Mapping<g,h> {

	Presentation<g,N> presentation();
	Representation<N,h> representation();

	@Override
	default h operate(g input) {
		return representation().represent(presentation().present(input));
	}

}
