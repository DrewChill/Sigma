package ml.kit.primitive.product.topo;

import ml.kit.primitive.Char;
import ml.kit.primitive.product.Product;
import ml.kit.primitive.str.ch.CharNode;

public abstract class PointedSpace<x,p,y> extends Product<Product<x,p>,Product<p,y>> implements CharNode<p> {

	public abstract Char<p> value();

	public abstract Pointer<x,p> getLeft();

	public abstract Pointer<p,y> getRight();

}
