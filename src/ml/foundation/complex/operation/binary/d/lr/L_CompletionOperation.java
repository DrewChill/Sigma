package ml.foundation.complex.operation.binary.d.lr;

import ml.foundation.primitive.Dense;
import ml.foundation.primitive.VOID;
import ml.foundation.complex.operation.binary.L_Absorbtion;

public abstract class L_CompletionOperation<one extends Dense, zero extends VOID> extends L_Absorbtion<one,zero> {

	@Override
	public abstract one operate(one left, zero right);

}
