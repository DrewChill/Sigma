package ml.foundation.math.operation.binary.v;

import ml.foundation.primitive.d.Dense;
import ml.foundation.primitive.l.Liminal;
import ml.foundation.primitive.v.VOID;
import ml.foundation.math.operation.binary.DenseOperation;

public abstract class DestructionOperation<one extends Dense, zero extends VOID>
		extends DenseOperation<one> implements VOID {

	@Override
	public abstract Liminal getCenter();

	@Override
	public abstract zero operate(one left, one right);

}
