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
			preIdentity extends Product<prefix,preCenter,result>,
			centralProduct extends Product<preCenter,result,center>>
	Operator<prefix,centralProduct,input,
			? extends Product<prefix,centralProduct,input>> prepend(
			Operator<prefix,preCenter,result,preIdentity> operator);


}
