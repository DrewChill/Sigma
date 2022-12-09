package archive;

import ml.kit.primitive.chiral.Left;
import ml.kit.primitive.chiral.Right;

public class aproduct<x,y> implements Left<x>, Right<y> {
	@Override
	public x getLeft() {
		return null;
	}

	@Override
	public y getRight() {
		return null;
	}
}
