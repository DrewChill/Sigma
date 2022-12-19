package ml.foundation.math.group;

import ml.foundation.primitive.d.Dense;
import ml.foundation.Preliminal;
import ml.foundation.primitive.v.VOID;
import ml.foundation.math.operation.binary.DenseOperation;
import ml.foundation.math.operation.binary.VoidOperation;
import ml.foundation.math.operation.binary.L_Absorbtion;
import ml.foundation.math.operation.binary.R_Absorbtion;

public interface SemiGroup<one extends Dense, zero extends VOID> extends Preliminal {

	VoidOperation<zero> OO();

	L_Absorbtion<one,zero> IO();

	R_Absorbtion<zero,one> OI();

	DenseOperation<one> II();

}
