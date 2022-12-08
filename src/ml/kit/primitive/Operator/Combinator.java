package ml.kit.primitive.Operator;

import ml.kit.primitive.num.number;
import ml.kit.primitive.presentation.Presentation;
import ml.kit.primitive.representation.Representation;

public class Combinator<Q extends number,c,N extends number> implements Operator<Q,N>{

	private final Representation<Q,c> representation;
	private final Presentation<c,N> presentation;

	public Combinator(Representation<Q,c> representation, Presentation<c,N> presentation) {
		this.representation = representation;
		this.presentation = presentation;
	}

	@Override
	public N operate(Q input) {
		return presentation.present(representation.represent(input));
	}

}
