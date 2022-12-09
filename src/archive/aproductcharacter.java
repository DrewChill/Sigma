package archive;

import ml.kit.primitive.chiral.Product;
import ml.kit.primitive.num.Complex;
import ml.kit.primitive.operator.Operator;

public class aproductcharacter<x,y> implements Product<x,y,aproduct<x,y>> {
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
	public <result> result read(Operator<aproduct<x,y>,result> options) {
		return null;
	}
}
