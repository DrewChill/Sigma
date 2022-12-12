package ml.kit.primitive.operator.construction.composition;

import ml.kit.primitive.product.DisjointProduct;
import ml.kit.primitive.num.Complex;
import ml.kit.primitive.operator.Mapping;

public class Composition<I, O, E> implements Mapping<I,E> {

	private final Mapping<I,O> first;
	private final Mapping<O,E> second;

	public Composition(Mapping<I,O> first, Mapping<O,E> second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public Complex complex() {
		return null;
	}

	@Override
	public Number real() {
		return null;
	}

	@Override
	public E operate(I input) {
		return second.operate(first.operate(input));
	}

	@Override
	public <E1> Mapping<I,E1> extend(Mapping<E,E1> operator) {
		return null;
	}

	@Override
	public <Q> Mapping<Q,E> prepend(Mapping<Q,I> operator) {
		return null;
	}

	@Override
	public DisjointProduct<I,E> real() {
		return null;
	}

	@Override
	public <result> result read(Mapping<DisjointProduct<I,E>,result> operator) {
		return null;
	}
}
