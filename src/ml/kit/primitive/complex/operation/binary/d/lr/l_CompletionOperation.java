package ml.kit.primitive.complex.operation.binary.d.lr;

import ml.kit.primitive.Dense;
import ml.kit.primitive.Liminal;
import ml.kit.primitive.VOID;
import ml.kit.primitive.complex.operation.Operation;
import ml.kit.primitive.complex.operation.binary.l_Absorbtion;

public abstract class l_CompletionOperation<one extends Dense, zero extends VOID> extends l_Absorbtion<one,zero> {

	@Override
	public abstract one operate(one left, zero right);

}
