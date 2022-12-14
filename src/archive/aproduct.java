package archive;

import ml.kit.primitive.direction.d_Left;
import ml.kit.primitive.direction.d_Right;

public class aproduct<x,y> implements d_Left<x>, d_Right<y> {
	@Override
	public x getLeft() {
		return null;
	}

	@Override
	public y getRight() {
		return null;
	}
}
