package ml.foundation.primitive.bias.invertible;

import ml.foundation.primitive.Dense;
import ml.foundation.primitive.bias.Bias;

public abstract class d_Invertible extends Bias<Dense> {

	@Override
	public abstract v_Invertible getCenter();

}
