package ml.kit.primitive.str.ch.action;

import ml.kit.primitive.Char;
import ml.kit.primitive.product.topo.Pointer;

public abstract class LeftPointer<b,c> extends Pointer<Char<b>,c> {

	public abstract LeftAction<b,c> value();

}
