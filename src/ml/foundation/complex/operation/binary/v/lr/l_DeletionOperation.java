package ml.foundation.complex.operation.binary.v.lr;

import ml.foundation.primitive.Dense;
import ml.foundation.primitive.VOID;
import ml.foundation.complex.operation.binary.l_Absorbtion;

public abstract class l_DeletionOperation<one extends Dense, zero extends VOID> extends l_Absorbtion<one,zero> {

	@Override
	public abstract zero operate(one left, zero right);

}
