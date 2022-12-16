package ml.foundation.complex.operation.binary.v.lr;

import ml.foundation.primitive.Dense;
import ml.foundation.primitive.VOID;
import ml.foundation.complex.operation.binary.L_Absorbtion;

public abstract class L_DeletionOperation<one extends Dense, zero extends VOID> extends L_Absorbtion<one,zero> {

	@Override
	public abstract zero operate(one left, zero right);

}
