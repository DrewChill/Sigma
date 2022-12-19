package ml.foundation.math.operation.binary.v.lr;

import ml.foundation.primitive.d.Dense;
import ml.foundation.primitive.v.VOID;
import ml.foundation.math.operation.binary.L_Absorbtion;

public abstract class L_DeletionOperation<one extends Dense, zero extends VOID> extends L_Absorbtion<one,zero> {

	@Override
	public abstract zero operate(one left, zero right);

}
