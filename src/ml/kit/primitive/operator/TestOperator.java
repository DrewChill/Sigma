package ml.kit.primitive.operator;

import ml.kit.primitive.chiral.Product;

public class TestOperator<I,O> implements Operator<I,O>{

	@Override
	public O operate(I input) {
		return null;
	}

	@Override
	public Product<I,O> real() {
		return null;
	}

	@Override
	public <result> result read(Operator<Product<I,O>,result> operator) {
		return null;
	}

	//----------------------

	@Override
	public <E> Operator<I,E> append(Operator<O,E> operator) {
		return null;
	}

	@Override
	public <Q> Operator<Q,O> prepend(Operator<Q,I> operator) {
		return null;
	}
}
