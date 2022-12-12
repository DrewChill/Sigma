package archive;

import ml.kit.primitive.product.Left;
import ml.kit.primitive.product.Right;

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
