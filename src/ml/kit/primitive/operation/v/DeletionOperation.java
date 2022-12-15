package ml.kit.primitive.operation.v;

import ml.kit.primitive.Dense;
import ml.kit.primitive.Liminal;
import ml.kit.primitive.VOID;
import ml.kit.primitive.operation.Operation;

public abstract class DeletionOperation<one extends Dense, zero extends VOID>
		extends Liminal implements Operation<zero,one,one> {
}
