package ml.foundation.complex.operation.binary.v;

import ml.foundation.primitive.VOID;
import ml.foundation.complex.operation.binary.VoidOperation;

public abstract class VirtualOperation<zero extends VOID> extends VoidOperation<zero> {

	@Override
	public abstract zero operate(zero left, zero right);

}
