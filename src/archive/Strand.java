package archive;

import ml.kit.primitive.str.string;

public interface Strand<g,x,h,y> extends string<g,h> {

	x lower();

	Strand<h,y,?,?> complex();

}
