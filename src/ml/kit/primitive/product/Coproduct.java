package ml.kit.primitive.product;

import ml.kit.primitive.Dense;
import ml.kit.primitive.Liminal;
import ml.kit.primitive.topo.Open;

public abstract class Coproduct extends Open implements Dense {

	@Override
	public abstract Liminal getCenter();

}
