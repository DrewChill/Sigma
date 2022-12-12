package ml.kit.primitive.operator;

import ml.kit.primitive.product.Product;
import ml.kit.primitive.str.TerminalCharacter;

public interface Operator<input,center,result,identity extends Product<input,center,result>> extends TerminalCharacter<identity> {

	result operate(input input);

	<extension,
			extensionCenter,
			extensionIdentity extends Product<result,extensionCenter,extension>,
			centralProduct extends Product<center,result,extensionCenter>,
			centralIdentity extends Product<input,centralProduct,extension>>
	Operator<input,centralProduct,extension,centralIdentity>
	append(Operator<result,extensionCenter,extension,extensionIdentity> operator);


}
