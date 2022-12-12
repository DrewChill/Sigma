package ml.kit.primitive.product.adjoint;

import ml.kit.primitive.str.AdjointCharacter;

public interface RightAdjoint<h,g> extends AdjointCharacter<h,g,LeftAdjoint<g,h>> { }
