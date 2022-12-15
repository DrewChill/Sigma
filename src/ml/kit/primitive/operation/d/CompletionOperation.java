package ml.kit.primitive.operation.d;

import ml.kit.primitive.Dense;
import ml.kit.primitive.Liminal;
import ml.kit.primitive.VOID;
import ml.kit.primitive.operation.Operation;

public abstract class CompletionOperation<one extends Dense, zero extends VOID>
		extends Liminal implements Operation<one,zero,zero> {
}
