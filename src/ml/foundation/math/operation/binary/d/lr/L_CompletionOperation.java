package ml.foundation.math.operation.binary.d.lr;

import ml.foundation.primitive.d.Dense;
import ml.foundation.primitive.v.VOID;
import ml.foundation.math.operation.binary.L_Absorbtion;

public abstract class L_CompletionOperation<one extends Dense, zero extends VOID> extends L_Absorbtion<one,zero> {

	@Override
	public abstract one operate(one left, zero right);

}
