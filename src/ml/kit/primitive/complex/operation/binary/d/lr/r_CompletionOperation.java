package ml.kit.primitive.complex.operation.binary.d.lr;

import ml.kit.primitive.Dense;
import ml.kit.primitive.VOID;
import ml.kit.primitive.complex.operation.binary.r_Absorbtion;

public abstract class r_CompletionOperation<zero extends VOID,one extends Dense> extends r_Absorbtion<zero,one> {

	@Override
	public abstract one operate(zero left, one right);

}
