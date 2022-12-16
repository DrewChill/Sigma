package ml.foundation.complex.operation.binary.v.lr;

import ml.foundation.primitive.Dense;
import ml.foundation.primitive.VOID;
import ml.foundation.complex.operation.binary.r_Absorbtion;

public abstract class r_DeletionOperation<zero extends VOID,one extends Dense> extends r_Absorbtion<zero,one> {

	@Override
	public abstract zero operate(zero left, one right);

}
