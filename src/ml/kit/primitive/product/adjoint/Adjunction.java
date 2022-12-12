package ml.kit.primitive.product.adjoint;

import ml.kit.primitive.EMPTY;
import ml.kit.primitive.operator.Mapping;
import ml.kit.primitive.product.Product;

public abstract class Adjunction<g,h> extends Product<g,EMPTY,h> {
	@Override
	public LeftAdjoint<g,h> getLeft() {
		return null;
	}

	@Override
	public RightAdjoint<h,g>  getRight() {
		return null;
	}

	@Override
	public EMPTY real() {
		return null;
	}

	@Override
	public <result> result read(Mapping<EMPTY,result> operator) {
		return null;
	}
}
