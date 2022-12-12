package ml.kit.primitive.operator.construction.composition;

import ml.kit.primitive.chiral.Product;
import ml.kit.primitive.num.Complex;
import ml.kit.primitive.operator.Operator;

public class Composition<I, O, E> implements Operator<I,E> {

	private final Operator<I,O> first;
	private final Operator<O,E> second;

	public Composition(Operator<I,O> first, Operator<O,E> second) {
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
	public <E1> Operator<I,E1> append(Operator<E,E1> operator) {
		return null;
	}

	@Override
	public <Q> Operator<Q,E> prepend(Operator<Q,I> operator) {
		return null;
	}

	@Override
	public Product<I,E> real() {
		return null;
	}

	@Override
	public <result> result read(Operator<Product<I,E>,result> operator) {
		return null;
	}
}
