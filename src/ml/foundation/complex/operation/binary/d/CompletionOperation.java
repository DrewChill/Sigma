package ml.foundation.complex.operation.binary.d;

import ml.foundation.primitive.Dense;
import ml.foundation.primitive.Liminal;
import ml.foundation.primitive.VOID;
import ml.foundation.complex.operation.binary.VoidOperation;

public abstract class CompletionOperation<one extends Dense, zero extends VOID>
		extends VoidOperation<zero> implements Dense {

	@Override
	public abstract Liminal getCenter();

	@Override
	public abstract one operate(zero left, zero right);

}
