package archive;

import ml.kit.primitive.product.DisjointProduct;
import ml.kit.primitive.num.Complex;
import ml.kit.primitive.operator.Op;

public class aproductcharacter<x,y> implements DisjointProduct<x,y,aproduct<x,y>> {
	@Override
	public Number real() {
		return null;
	}

	@Override
	public Complex complex() {
		return null;
	}

	@Override
	public aproduct<x,y> image() {
		return null;
	}

	@Override
	public <result> result read(Op<aproduct<x,y>,result> options) {
		return null;
	}
}
