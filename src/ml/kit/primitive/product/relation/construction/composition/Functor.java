package ml.kit.primitive.product.relation.construction.composition;

import ml.kit.primitive.num.Complex;
import ml.kit.primitive.product.relation.construction.Presentation;
import ml.kit.primitive.product.relation.construction.Representation;
import ml.kit.primitive.product.relation.Op;

public interface Functor<g,N extends Complex,h> extends Op<g,h> {

	Presentation<g,N> presentation();
	Representation<N,h> representation();

	@Override
	default h operate(g input) {
		return representation().represent(presentation().present(input));
	}

}
