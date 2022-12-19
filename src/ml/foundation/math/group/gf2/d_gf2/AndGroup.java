package ml.foundation.math.group.gf2.d_gf2;

import ml.foundation.math.group.SemiGroup;
import ml.foundation.math.operation.binary.d.StaticOperation;
import ml.foundation.math.operation.binary.v.VirtualOperation;
import ml.foundation.math.operation.binary.v.lr.L_DeletionOperation;
import ml.foundation.math.operation.binary.v.lr.R_DeletionOperation;
import ml.foundation.primitive.d.Dense;
import ml.foundation.primitive.v.VOID;

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
