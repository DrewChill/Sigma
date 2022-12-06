package ml.kit.primitive;

import ml.kit.primitive.num.Num;

public interface Product<g,h> extends Num {

	g left();

	//alias complex
	default Product<h,?> right(){
		return complex();
	}

	Product<h,?> complex();



}
