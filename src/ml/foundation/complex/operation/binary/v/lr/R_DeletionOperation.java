package ml.foundation.complex.operation.binary.v.lr;

import ml.foundation.primitive.Dense;
import ml.foundation.primitive.VOID;
import ml.foundation.complex.operation.binary.R_Absorbtion;

public abstract class R_DeletionOperation<zero extends VOID,one extends Dense> extends R_Absorbtion<zero,one> {

	@Override
	public abstract zero operate(zero left, one right);

}
