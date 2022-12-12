package ml.kit.primitive.operator;

import ml.kit.primitive.product.Product;
import ml.kit.primitive.str.TerminalCharacter;

public interface Operator<input,center,result,identity extends Product<input,center,result>> extends TerminalCharacter<identity> {

	result operate(input input);

	<extension,
			extCenter,
			extIdentity extends Product<result,extCenter,extension>,
			centralProduct extends Product<center,result,extCenter>>
	Operator<input,centralProduct,extension,
			? extends Product<input,centralProduct,extension>> append(
					Operator<result,extCenter,extension,extIdentity> operator);

	<prefix,
			preCenter,
			preIdentity extends Product<prefix,preCenter,input>,
			centralProduct extends Product<preCenter,input,center>>
	Operator<prefix,centralProduct,result,
			? extends Product<prefix,centralProduct,result>> prepend(
			Operator<prefix,preCenter,input,preIdentity> operator);


}
