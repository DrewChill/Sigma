package archive.relation;

import archive.adjoint.Adjunction;
import archive.adjoint.Adjoint;

public abstract class InvertibleRelation<g,h> implements
		Action<g,NullCharacter,h,Adjunction<g,h>>,
		Adjoint<Adjunction<g,h>,Adjunction<h,g>,InvertibleRelation<h,g>> {

}
