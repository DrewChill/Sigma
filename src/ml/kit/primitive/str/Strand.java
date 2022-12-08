package ml.kit.primitive.str;

public interface Strand<g,x,h,y> extends Str<g,h> {

	x lower();

	Strand<h,y,?,?> complex();

}
