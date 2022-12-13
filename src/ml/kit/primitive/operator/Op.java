package ml.kit.primitive.operator;

import ml.kit.primitive.Nothing;
import ml.kit.primitive.product.DisjointProduct;

//character is the left/right identity
public interface Op<input,result> extends Operator<input,Nothing,result,DisjointProduct<input,result>> {

	<E> Op<input,E> append(Op<result,E> operator);

	<E> Op<E,result> prepend(Op<E,input> operator);

}
