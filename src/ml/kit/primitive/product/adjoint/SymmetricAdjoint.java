package ml.kit.primitive.product.adjoint;

import ml.kit.primitive.str.AdjointCharacter;

public interface SymmetricAdjoint<g,h> extends AdjointCharacter<g,h,SymmetricAdjoint<h,g>> {
}
