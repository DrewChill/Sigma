package ml.foundation.complex.group.binary;

import ml.foundation.complex.group.SemiGroup;
import ml.foundation.complex.operation.binary.d.lr.L_CompletionOperation;
import ml.foundation.complex.operation.binary.d.lr.R_CompletionOperation;
import ml.foundation.complex.operation.binary.v.DeletionOperation;
import ml.foundation.complex.operation.binary.v.VirtualOperation;
import ml.foundation.primitive.Dense;
import ml.foundation.primitive.VOID;

public interface XorGroup<one extends Dense, zero extends VOID> extends SemiGroup<one,zero> {

	@Override
	DeletionOperation<one,zero> II();

	@Override
	R_CompletionOperation<zero,one> OI();

	@Override
	L_CompletionOperation<one,zero> IO();

	@Override
	VirtualOperation<zero> OO();

}
