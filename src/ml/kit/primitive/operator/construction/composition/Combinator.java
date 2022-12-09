package ml.kit.primitive.operator.construction.composition;

import ml.kit.primitive.num.Complex;
import ml.kit.primitive.operator.construction.Presentation;
import ml.kit.primitive.operator.construction.Representation;
import ml.kit.primitive.operator.Operator;

public interface Combinator<Q extends Complex,c,N extends Complex> extends Operator<Q,N> {

	Representation<Q,c> representation();
	Presentation<c,N> presentation();

	@Override
	default N operate(Q input) {
		return presentation().present(representation().represent(input));
	}

}
