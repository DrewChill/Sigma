package ml.kit.primitive.product.adjoint;

import ml.kit.primitive.str.AdjointCharacter;

public interface LeftAdjoint<g,h> extends AdjointCharacter<g,h,RightAdjoint<h,g>> { }
