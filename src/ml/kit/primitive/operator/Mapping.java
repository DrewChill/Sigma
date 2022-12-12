package ml.kit.primitive.operator;

import ml.kit.primitive.EMPTY;
import ml.kit.primitive.product.DisjointProduct;
import ml.kit.primitive.str.TerminalCharacter;

//character is the left/right identity
public interface Mapping<input,result> extends Operator<input,EMPTY,result,DisjointProduct<input,result>> {

	result operate(input input);

	<E> Mapping<input,E> append(Mapping<result,E> operator);

	<Q> Mapping<Q,result> prepend(Mapping<Q,input> operator);

}
