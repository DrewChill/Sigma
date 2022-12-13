package ml.kit.primitive.str.ch.action;

import ml.kit.primitive.Char;
import ml.kit.primitive.product.topo.Pointer;

public abstract class RightPointer<a,b> extends Pointer<a,Char<b>> {

	public abstract RightAction<a,b> value();

}
