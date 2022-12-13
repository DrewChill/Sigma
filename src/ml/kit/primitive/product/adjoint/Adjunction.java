package ml.kit.primitive.product.adjoint;

import ml.kit.primitive.Nothing;
import ml.kit.primitive.product.Product;

public abstract class Adjunction<g,h> extends Product<g,Nothing,h> {

	@Override
	public abstract SymmetricAdjoint<g,h> getLeft();

	@Override
	public abstract SymmetricAdjoint<h,g>  getRight();

}
