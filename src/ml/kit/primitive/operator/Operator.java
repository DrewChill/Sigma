package ml.kit.primitive.operator;

import ml.kit.primitive.product.Product;
import ml.kit.primitive.str.TerminalCharacter;

public interface Operator<input,center,result> extends TerminalCharacter<center> {

	result operate(input input);

	<extension, e_center, centralProduct extends Product<center,result,e_center>>
	Operator<input,centralProduct,extension> append(Operator<result,e_center,extension> operator);

	<prefix, p_center, centralProduct extends Product<p_center,input,center>>
	Operator<prefix,centralProduct,result> prepend(Operator<prefix,p_center,input> operator);


}
