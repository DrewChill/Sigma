package ml.kit.primitive.operator;

import ml.kit.primitive.product.Product;
import ml.kit.primitive.str.TerminalCharacter;

public interface Operator<input,j,result,identity extends Product<input,j,result>> extends TerminalCharacter<identity> {

	result operate(input input);

	<E> Mapping<input,E> append(Mapping<result,E> operator);

	<Q> Mapping<Q,result> prepend(Mapping<Q,input> operator);


}
