package ml.kit.primitive.product.adjoint;

public interface RightAdjoint<h,g> extends Adjoint<h,g,LeftAdjoint<g,h>> { }
