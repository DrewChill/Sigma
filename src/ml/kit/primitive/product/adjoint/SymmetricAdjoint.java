package ml.kit.primitive.product.adjoint;

public interface SymmetricAdjoint<g,h> extends Adjoint<g,h,SymmetricAdjoint<h,g>> {
}