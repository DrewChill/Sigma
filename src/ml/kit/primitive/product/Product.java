package ml.kit.primitive.product;

import ml.kit.primitive.Liminal;
import ml.kit.primitive.VOID;
import ml.kit.primitive.topo.Closed;

public abstract class Product extends Closed implements VOID {

	@Override
	public abstract Liminal getCenter();

}
