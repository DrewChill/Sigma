package ml.foundation.math.group.gf2.d_gf2;

import ml.foundation.math.group.SemiGroup;
import ml.foundation.math.operation.binary.d.lr.L_CompletionOperation;
import ml.foundation.math.operation.binary.d.lr.R_CompletionOperation;
import ml.foundation.math.operation.binary.v.DestructionOperation;
import ml.foundation.math.operation.binary.v.VirtualOperation;
import ml.foundation.primitive.d.Dense;
import ml.foundation.primitive.v.VOID;

public interface XorGroup<one extends Dense, zero extends VOID> extends SemiGroup<one,zero> {

	@Override
	VirtualOperation<zero> OO();

	@Override
	L_CompletionOperation<one,zero> IO();

	@Override
	R_CompletionOperation<zero,one> OI();

	@Override
	DestructionOperation<one,zero> II();

}
