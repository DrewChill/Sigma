package ml.foundation.complex.group.binary;

import ml.foundation.complex.group.SemiGroup;
import ml.foundation.complex.operation.binary.d.StaticOperation;
import ml.foundation.complex.operation.binary.v.VirtualOperation;
import ml.foundation.complex.operation.binary.v.lr.L_DeletionOperation;
import ml.foundation.complex.operation.binary.v.lr.R_DeletionOperation;
import ml.foundation.primitive.Dense;
import ml.foundation.primitive.VOID;

public interface AndGroup<one extends Dense, zero extends VOID> extends SemiGroup<one,zero> {

	@Override
	VirtualOperation<zero> OO();

	@Override
	L_DeletionOperation<one,zero> IO();

	@Override
	R_DeletionOperation<zero,one> OI();

	@Override
	StaticOperation<one> II();

}
