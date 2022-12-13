package ml.kit.primitive.operator.construction;

import ml.kit.primitive.product.DisjointProduct;
import ml.kit.primitive.num.Complex;
import ml.kit.primitive.operator.Op;

public class TestRepresentation<R,N extends Complex> implements Op<R,N> {
	@Override
	public Number real() {
		return null;
	}

	@Override
	public Complex complex() {
		return null;
	}

	@Override
	public N operate(R input) {
		return null;
	}

	@Override
	public <E> Op<R,E> extend(Op<N,E> operator) {
		return null;
	}

	@Override
	public <Q> Op<Q,N> prepend(Op<Q,R> operator) {
		return null;
	}

	@Override
	public DisjointProduct<R,N> real() {
		return null;
	}

	@Override
	public <result> result read(Op<DisjointProduct<R,N>,result> operator) {
		return null;
	}
}
