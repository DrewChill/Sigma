package ml.kit.primitive.complex.operation.binary.d.lr;

import ml.kit.primitive.Dense;
import ml.kit.primitive.Liminal;
import ml.kit.primitive.VOID;
import ml.kit.primitive.complex.operation.Operation;
import ml.kit.primitive.complex.operation.binary.l_Absorbtion;
import ml.kit.primitive.complex.operation.binary.r_Absorbtion;

public abstract class r_CompletionOperation<one extends Dense, zero extends VOID> extends r_Absorbtion<one,zero> {

	@Override
	public abstract one operate(zero left, one right);

}
