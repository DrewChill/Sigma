package archive.bias.invertible;

import ml.foundation.primitive.v.VOID;
import archive.bias.LiminalBias;

public abstract class VoidInvertible extends LiminalBias<VOID> {

	@Override
	public abstract DenseInvertible getCenter();

}
