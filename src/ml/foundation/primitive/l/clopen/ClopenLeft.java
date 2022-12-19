package ml.foundation.primitive.l.clopen;

import ml.foundation.primitive.l.Liminal;
import ml.foundation.primitive.d.DenseRight;
import ml.foundation.primitive.v.VoidLeft;

public abstract class ClopenLeft implements VoidLeft, DenseRight {

	@Override
	public abstract Liminal getCenter();

}
