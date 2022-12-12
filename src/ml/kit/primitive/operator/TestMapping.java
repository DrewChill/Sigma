package ml.kit.primitive.operator;

import ml.kit.primitive.product.DisjointProduct;

public class TestMapping<I,O> implements Mapping<I,O> {

	@Override
	public O operate(I input) {
		return null;
	}

	@Override
	public DisjointProduct<I,O> real() {
		return null;
	}

	@Override
	public <result> result read(Mapping<DisjointProduct<I,O>,result> operator) {
		return null;
	}

	//----------------------

	@Override
	public <E> Mapping<I,E> append(Mapping<O,E> operator) {
		return null;
	}

	@Override
	public <Q> Mapping<Q,O> prepend(Mapping<Q,I> operator) {
		return null;
	}
}
