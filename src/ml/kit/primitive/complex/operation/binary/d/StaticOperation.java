package ml.kit.primitive.complex.operation.binary.d;

import ml.kit.primitive.Dense;
import ml.kit.primitive.complex.operation.binary.DenseOperation;

public abstract class StaticOperation<one extends Dense> extends DenseOperation<one> {

	@Override
	public abstract one operate(one left, one right);

}
