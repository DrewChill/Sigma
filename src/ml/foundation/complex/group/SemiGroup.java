package ml.foundation.complex.group;

import ml.foundation.primitive.Dense;
import ml.foundation.primitive.Preliminal;
import ml.foundation.primitive.VOID;
import ml.foundation.complex.operation.binary.DenseOperation;
import ml.foundation.complex.operation.binary.VoidOperation;
import ml.foundation.complex.operation.binary.l_Absorbtion;
import ml.foundation.complex.operation.binary.r_Absorbtion;

public interface SemiGroup<one extends Dense, zero extends VOID> extends Preliminal {

	VoidOperation<zero> OO();

	l_Absorbtion<one,zero> IO();

	r_Absorbtion<zero,one> OI();

	DenseOperation<one> II();

}
