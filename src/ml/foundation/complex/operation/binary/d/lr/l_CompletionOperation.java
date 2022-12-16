package ml.foundation.complex.operation.binary.d.lr;

import ml.foundation.primitive.Dense;
import ml.foundation.primitive.VOID;
import ml.foundation.complex.operation.binary.l_Absorbtion;

public abstract class l_CompletionOperation<one extends Dense, zero extends VOID> extends l_Absorbtion<one,zero> {

	@Override
	public abstract one operate(one left, zero right);

}
