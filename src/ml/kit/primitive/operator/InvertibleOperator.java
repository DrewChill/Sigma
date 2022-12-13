package ml.kit.primitive.operator;

import ml.kit.primitive.Nothing;
import ml.kit.primitive.product.adjoint.Adjunction;
import ml.kit.primitive.product.adjoint.Adjoint;

public abstract class InvertibleOperator<g,h> implements
		Operator<g,Nothing,h,Adjunction<g,h>>,
		Adjoint<Adjunction<g,h>,Adjunction<h,g>,InvertibleOperator<h,g>> {

}
