package ml.kit.primitive.Operator;

import ml.kit.primitive.num.number;
import ml.kit.primitive.presentation.Presentation;
import ml.kit.primitive.representation.Representation;

public class Functor<g,N extends number,h> implements Operator<g,h> {

	private final Presentation<g,N> presentation;
	private final Representation<N,h> representation;

	public Functor(Presentation<g,N> presentation, Representation<N,h> representation) {
		this.presentation = presentation;
		this.representation = representation;
	}

	@Override
	public h operate(g input) {
		return representation.represent(presentation.present(input));
	}

}
