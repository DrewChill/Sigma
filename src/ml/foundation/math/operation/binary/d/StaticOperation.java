package ml.foundation.math.operation.binary.d;

import ml.foundation.primitive.d.Dense;
import ml.foundation.math.operation.binary.DenseOperation;

public abstract class StaticOperation<one extends Dense> extends DenseOperation<one> {

	@Override
	public abstract one operate(one left, one right);

}
