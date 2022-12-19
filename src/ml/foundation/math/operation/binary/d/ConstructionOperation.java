package ml.foundation.math.operation.binary.d;

import ml.foundation.primitive.d.Dense;
import ml.foundation.primitive.l.Liminal;
import ml.foundation.primitive.v.VOID;
import ml.foundation.math.operation.binary.VoidOperation;

public abstract class ConstructionOperation<one extends Dense, zero extends VOID>
		extends VoidOperation<zero> implements Dense {

	@Override
	public abstract Liminal getCenter();

	@Override
	public abstract one operate(zero left, zero right);

}
