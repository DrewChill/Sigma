package ml.kit.primitive.complex.operation.binary.d;

import ml.kit.primitive.Dense;
import ml.kit.primitive.Liminal;
import ml.kit.primitive.VOID;
import ml.kit.primitive.complex.operation.binary.VoidOperation;

public abstract class CompletionOperation<one extends Dense, zero extends VOID>
		extends VoidOperation<zero> implements Dense {

	@Override
	public abstract Liminal getCenter();

	@Override
	public abstract one operate(zero left, zero right);

}
