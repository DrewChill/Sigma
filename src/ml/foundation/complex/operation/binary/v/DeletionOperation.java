package ml.foundation.complex.operation.binary.v;

import ml.foundation.primitive.Dense;
import ml.foundation.primitive.Liminal;
import ml.foundation.primitive.VOID;
import ml.foundation.complex.operation.binary.DenseOperation;

public abstract class DeletionOperation<one extends Dense, zero extends VOID>
		extends DenseOperation<one> implements VOID {

	@Override
	public abstract Liminal getCenter();

	@Override
	public abstract zero operate(one left, one right);

}
