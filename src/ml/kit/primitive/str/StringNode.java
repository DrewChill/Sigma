package ml.kit.primitive.str;

import ml.kit.primitive.Char;
import ml.kit.primitive.product.topo.PointedSpace;
import ml.kit.primitive.str.ch.CharNode;
import ml.kit.primitive.str.ch.action.LeftPointer;
import ml.kit.primitive.str.ch.action.RightPointer;

public abstract class StringNode<a,b,c> extends PointedSpace<Char<a>,b,Char<c>> implements CharNode<b> {

	public abstract Char<b> value();

	public abstract LeftPointer<a,b> getLeft();

	public abstract RightPointer<b,c> getRight();

}
