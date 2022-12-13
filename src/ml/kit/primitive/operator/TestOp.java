package ml.kit.primitive.operator;

import ml.kit.primitive.product.DisjointProduct;

public class TestOp<I,O> implements Op<I,O> {

	@Override
	public O operate(I input) {
		return null;
	}

	@Override
	public DisjointProduct<I,O> real() {
		return null;
	}

	@Override
	public <result> result read(Op<DisjointProduct<I,O>,result> operator) {
		return null;
	}

	//----------------------

	@Override
	public <E> Op<I,E> extend(Op<O,E> operator) {
		return null;
	}

	@Override
	public <Q> Op<Q,O> prepend(Op<Q,I> operator) {
		return null;
	}
}
