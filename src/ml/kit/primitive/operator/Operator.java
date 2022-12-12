package ml.kit.primitive.operator;

import ml.kit.primitive.chiral.Product;
import ml.kit.primitive.str.TerminalCharacter;

//character is the left/right identity
public interface Operator<input,result> extends TerminalCharacter<Product<input,result>> {

	result operate(input input);

	<E> Operator<input,E> append(Operator<result,E> operator);

	<Q> Operator<Q,result> prepend(Operator<Q,input> operator);

}
