package ml.kit.primitive.operator;

import ml.kit.primitive.chiral.Product;
import ml.kit.primitive.str.character;

//character is the left/right identity
public interface Operator<I,O> extends character<Product<I,O>> {

	O operate(I input);

	<E> Operator<I,E> append(Operator<O,E> operator);

	<Q> Operator<Q,O> prepend(Operator<Q,I> operator);

}
