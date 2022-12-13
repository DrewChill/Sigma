package ml.kit.primitive.product.relation.construction;

import ml.kit.primitive.product.DisjointRelation;
import ml.kit.primitive.num.Complex;
import ml.kit.primitive.product.relation.Op;

public class TestPresentation<R,N extends Complex> implements Presentation<R,N>{

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
	public N present(R representation) {
		return null;
	}

	@Override
	public DisjointRelation<R,N> real() {
		return null;
	}

	@Override
	public <result> result read(Op<DisjointRelation<R,N>,result> operator) {
		return null;
	}
}
