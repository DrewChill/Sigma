package ml.kit.primitive.str.ch.action;

import ml.kit.primitive.Char;
import ml.kit.primitive.product.Product;
import ml.kit.primitive.str.ch.CharNode;

public abstract class RightAction<a,b> extends Product<a,Char<b>> {

	public abstract Char<a> getLeft();

	public abstract CharNode<b> getRight();

}
