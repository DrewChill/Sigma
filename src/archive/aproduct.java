package archive;

import ml.foundation.primitive.d.DenseLeft;
import ml.foundation.primitive.d.DenseRight;

public class aproduct<x,y> implements DenseLeft<x>, DenseRight<y> {
	@Override
	public x getLeft() {
		return null;
	}

	@Override
	public y getRight() {
		return null;
	}
}
