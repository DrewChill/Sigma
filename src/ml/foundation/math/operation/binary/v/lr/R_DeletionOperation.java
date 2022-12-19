package ml.foundation.math.operation.binary.v.lr;

import ml.foundation.primitive.d.Dense;
import ml.foundation.primitive.v.VOID;
import ml.foundation.math.operation.binary.R_Absorbtion;

public abstract class R_DeletionOperation<zero extends VOID,one extends Dense> extends R_Absorbtion<zero,one> {

	@Override
	public abstract zero operate(zero left, one right);

}
