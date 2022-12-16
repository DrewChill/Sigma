package ml.foundation.complex.product;

import ml.foundation.primitive.Dense;
import ml.foundation.primitive.Liminal;
import ml.foundation.complex.topo.Open;

public abstract class Coproduct extends Open implements Dense {

	@Override
	public abstract Liminal getCenter();

}
