package ml.foundation.complex.product;

import ml.foundation.primitive.Liminal;
import ml.foundation.primitive.VOID;
import ml.foundation.complex.topo.Closed;

public abstract class Product extends Closed implements VOID {

	@Override
	public abstract Liminal getCenter();

}
