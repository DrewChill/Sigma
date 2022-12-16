package ml.kit.primitive.complex.group;

import ml.kit.primitive.Dense;
import ml.kit.primitive.Preliminal;
import ml.kit.primitive.VOID;
import ml.kit.primitive.complex.operation.binary.DenseOperation;
import ml.kit.primitive.complex.operation.binary.VoidOperation;
import ml.kit.primitive.complex.operation.binary.l_Absorbtion;
import ml.kit.primitive.complex.operation.binary.r_Absorbtion;

public interface SemiGroup<one extends Dense, zero extends VOID> extends Preliminal {

	VoidOperation<zero> OO();

	l_Absorbtion<one,zero> IO();

	r_Absorbtion<zero,one> OI();

	DenseOperation<one> II();

}
