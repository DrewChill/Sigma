package ml.foundation.math.operation.binary.d.lr;

import ml.foundation.primitive.d.Dense;
import ml.foundation.primitive.v.VOID;
import ml.foundation.math.operation.binary.R_Absorbtion;

public abstract class R_CompletionOperation<zero extends VOID,one extends Dense> extends R_Absorbtion<zero,one> {

	@Override
	public abstract one operate(zero left, one right);

}
