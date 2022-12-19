package ml.foundation.math.operation.binary.v;

import ml.foundation.primitive.v.VOID;
import ml.foundation.math.operation.binary.VoidOperation;

public abstract class VirtualOperation<zero extends VOID> extends VoidOperation<zero> {

	@Override
	public abstract zero operate(zero left, zero right);

}
