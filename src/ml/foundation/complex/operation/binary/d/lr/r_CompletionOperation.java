package ml.foundation.complex.operation.binary.d.lr;

import ml.foundation.primitive.Dense;
import ml.foundation.primitive.VOID;
import ml.foundation.complex.operation.binary.r_Absorbtion;

public abstract class r_CompletionOperation<zero extends VOID,one extends Dense> extends r_Absorbtion<zero,one> {

	@Override
	public abstract one operate(zero left, one right);

}
