package ml.kit.primitive.str;

import ml.kit.primitive.num.Rational;

public interface strand<g,x,h,y> extends Rational {

	g upper();

	x lower();

	strand<h,y,?,?> complex();

	//alias complex
	default strand<h,y,?,?> right(){
		return complex();
	}

}
