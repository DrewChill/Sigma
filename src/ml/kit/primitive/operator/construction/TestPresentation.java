package ml.kit.primitive.operator.construction;

import ml.kit.primitive.chiral.Product;
import ml.kit.primitive.num.Complex;
import ml.kit.primitive.operator.Operator;

public class TestPresentation<R,N extends Complex> implements Presentation<R,N>{

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
	public N present(R representation) {
		return null;
	}

	@Override
	public Product<R,N> real() {
		return null;
	}

	@Override
	public <result> result read(Operator<Product<R,N>,result> operator) {
		return null;
	}
}
