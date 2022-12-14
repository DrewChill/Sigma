package archive.adjoint;

import archive.relation.Relation;

public abstract class Adjunction<g,h> extends Relation<g,NullCharacter,h> {

	@Override
	public abstract SymmetricAdjoint<g,h> getLeft();

	@Override
	public abstract SymmetricAdjoint<h,g>  getRight();

}
