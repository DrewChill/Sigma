package ml.kit.primitive.product.topo;

import ml.kit.primitive.Char;
import ml.kit.primitive.product.Product;

public abstract class Pointer<a,b> implements Char<Product<a,b>> {

	public abstract Product<a,b> value();

}
