package ml.kit.primitive.complex.operation.binary.v;

import ml.kit.primitive.Dense;
import ml.kit.primitive.Liminal;
import ml.kit.primitive.VOID;
import ml.kit.primitive.complex.operation.Operation;
import ml.kit.primitive.complex.operation.binary.DenseOperation;

public abstract class DeletionOperation<one extends Dense, zero extends VOID>
		extends DenseOperation<one> implements VOID {

	@Override
	public abstract Liminal getCenter();

	@Override
	public abstract zero operate(one left, one right);

}
