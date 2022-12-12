package ml.kit.primitive.operator;

import ml.kit.primitive.product.adjoint.Adjunction;

public interface InvertibleOperator<g,h> extends Operator<g,Adjunction<g,h>,h> {}
