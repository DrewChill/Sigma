package ml.kit.primitive.product.relation;

import ml.kit.primitive.product.adjoint.Adjunction;
import ml.kit.primitive.product.adjoint.Adjoint;

public abstract class InvertibleRelation<g,h> implements
		Action<g,NullCharacter,h,Adjunction<g,h>>,
		Adjoint<Adjunction<g,h>,Adjunction<h,g>,InvertibleRelation<h,g>> {

}
