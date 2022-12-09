package ml.kit.primitive.operator.construction;

import ml.kit.primitive.chiral.Product;
import ml.kit.primitive.num.Complex;
import ml.kit.primitive.operator.Operator;

public class TestRepresentation<R,N extends Complex> implements Operator<R,N> {
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
	public <E> Operator<R,E> append(Operator<N,E> operator) {
		return null;
	}

	@Override
	public <Q> Operator<Q,N> prepend(Operator<Q,R> operator) {
		return null;
	}

	@Override
	public Product<R,N> kernel() {
		return null;
	}

	@Override
	public <result> result read(Operator<Product<R,N>,result> options) {
		return null;
	}
}
