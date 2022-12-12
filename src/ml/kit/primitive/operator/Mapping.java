package ml.kit.primitive.operator;

import ml.kit.primitive.EMPTY;

//character is the left/right identity
public interface Mapping<input,result> extends Operator<input,EMPTY,result> {

	<E> Mapping<input,E> append(Mapping<result,E> operator);

	<E> Mapping<E,result> prepend(Mapping<E,input> operator);

}
