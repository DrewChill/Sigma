package archive.bias.invertible;

import ml.foundation.primitive.d.Dense;
import archive.bias.LiminalBias;

public abstract class DenseInvertible extends LiminalBias<Dense> {

	@Override
	public abstract VoidInvertible getCenter();

}
