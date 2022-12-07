package ml.kit.primitive.str;

public interface string<g,rg extends Reader<g>,h, rh extends Reader<h>> extends strand<g,rg,h,rh> {

	g letter();

	string<h,rh,?,?> complex();

	//alias complex
	default string<h,rh,?,?> right(){
		return complex();
	}

}