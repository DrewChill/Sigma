package archive.relation.construction.composition;

import archive.relation.DisjointRelation;
import ml.kit.primitive.num.Complex;
import archive.relation.Op;

public class Composition<I, O, E> implements Op<I,E> {

	private final Op<I,O> first;
	private final Op<O,E> second;

	public Composition(Op<I,O> first, Op<O,E> second) {
		this.first = first;
		this.second = second;
	}

	public Complex value() {
		return null;
	}

	public Number real() {
		return null;
	}

	@Override
	public E operate(I input) {
		return second.operate(first.operate(input));
	}

	@Override
	public <E1> Op<I,E1> extend(Op<E,E1> operator) {
		return null;
	}

	@Override
	public <Q> Op<Q,E> prepend(Op<Q,I> operator) {
		return null;
	}

	@Override
	public DisjointRelation<I,E> real() {
		return null;
	}

	@Override
	public <result> result read(Op<DisjointRelation<I,E>,result> operator) {
		return null;
	}
}
