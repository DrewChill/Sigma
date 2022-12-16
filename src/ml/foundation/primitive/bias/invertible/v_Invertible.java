package ml.foundation.primitive.bias.invertible;

import ml.foundation.primitive.VOID;
import ml.foundation.primitive.bias.Bias;

public abstract class v_Invertible extends Bias<VOID> {

	@Override
	public abstract d_Invertible getCenter();

}
