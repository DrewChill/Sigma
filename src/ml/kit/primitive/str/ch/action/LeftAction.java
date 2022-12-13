package ml.kit.primitive.str.ch.action;

import ml.kit.primitive.Char;
import ml.kit.primitive.product.Product;
import ml.kit.primitive.str.ch.CharNode;

public abstract class LeftAction<b,c> extends Product<Char<b>,c> {

	public abstract CharNode<b> getLeft();

	public abstract Char<c> getRight();

}
