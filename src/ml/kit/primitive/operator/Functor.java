package ml.kit.primitive.operator;

import ml.kit.primitive.num.number;
import ml.kit.primitive.construction.Presentation;
import ml.kit.primitive.construction.Representation;

public interface Functor<g,N extends number,h> extends Operator<g,h> {

	Presentation<g,N> presentation();
	Representation<N,h> representation();

	@Override
	default h operate(g input) {
		return representation().represent(presentation().present(input));
	}

}
