package ml.kit.primitive.operator;

import ml.kit.primitive.num.number;
import ml.kit.primitive.construction.Presentation;
import ml.kit.primitive.construction.Representation;

public interface Combinator<Q extends number,c,N extends number> extends Operator<Q,N>{

	Representation<Q,c> representation();
	Presentation<c,N> presentation();

	@Override
	default N operate(Q input) {
		return presentation().present(representation().represent(input));
	}

}
