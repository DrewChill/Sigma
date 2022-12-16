package ml.kit.primitive.complex.operation.binary.v.lr;

import ml.kit.primitive.Dense;
import ml.kit.primitive.Liminal;
import ml.kit.primitive.VOID;
import ml.kit.primitive.complex.operation.Operation;
import ml.kit.primitive.complex.operation.binary.r_Absorbtion;

public abstract class r_DeletionOperation<one extends Dense, zero extends VOID> extends r_Absorbtion<one,zero> {

	@Override
	public abstract zero operate(zero left, one right);

}
