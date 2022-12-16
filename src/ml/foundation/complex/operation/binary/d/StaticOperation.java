package ml.foundation.complex.operation.binary.d;

import ml.foundation.primitive.Dense;
import ml.foundation.complex.operation.binary.DenseOperation;

public abstract class StaticOperation<one extends Dense> extends DenseOperation<one> {

	@Override
	public abstract one operate(one left, one right);

}
