package ml.kit.primitive.product.relation;

import ml.kit.primitive.product.DisjointRelation;

//character is the left/right identity
public interface Op<input,result> extends Action<input,NullCharacter,result,DisjointRelation<input,result>> {

	result operate(input input);

	<E> Op<input,E> append(Op<result,E> operator);

	<E> Op<E,result> prepend(Op<E,input> operator);

}
