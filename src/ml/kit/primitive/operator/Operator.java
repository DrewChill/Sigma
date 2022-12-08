package ml.kit.primitive.operator;

import ml.kit.primitive.num.number;

public interface Operator<I,O> extends number {

	O operate(I input);

	<E> Operator<I,E> append(Operator<O,E> operator);

	<Q> Operator<Q,O> prepend(Operator<Q,I> operator);

}
