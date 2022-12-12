package ml.kit.primitive.operator.construction;

import ml.kit.primitive.product.DisjointProduct;
import ml.kit.primitive.num.Complex;
import ml.kit.primitive.operator.Mapping;

public class TestPresentation<R,N extends Complex> implements Presentation<R,N>{

	@Override
	public N operate(R input) {
		return null;
	}

	@Override
	public <E> Mapping<R,E> append(Mapping<N,E> operator) {
		return null;
	}

	@Override
	public <Q> Mapping<Q,N> prepend(Mapping<Q,R> operator) {
		return null;
	}

	@Override
	public N present(R representation) {
		return null;
	}

	@Override
	public DisjointProduct<R,N> real() {
		return null;
	}

	@Override
	public <result> result read(Mapping<DisjointProduct<R,N>,result> operator) {
		return null;
	}
}
