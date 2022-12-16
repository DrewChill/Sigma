package ml.kit.primitive.complex.operation.binary.v;

import ml.kit.primitive.VOID;
import ml.kit.primitive.complex.operation.binary.VoidOperation;

public abstract class VirtualOperation<zero extends VOID> extends VoidOperation<zero> {

	@Override
	public abstract zero operate(zero left, zero right);

}
