package ml.kit.primitive.product.adjoint;

import ml.kit.primitive.product.Relation;

public abstract class Adjunction<g,h> extends Relation<g,NullCharacter,h> {

	@Override
	public abstract SymmetricAdjoint<g,h> getLeft();

	@Override
	public abstract SymmetricAdjoint<h,g>  getRight();

}
