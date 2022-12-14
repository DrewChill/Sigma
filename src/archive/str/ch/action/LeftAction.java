package archive.str.ch.action;

import ml.kit.primitive.Dense;
import ml.kit.primitive.topo.Closed;

public abstract class LeftAction<a,b> extends Closed<a,Dense<b>> {

	public abstract a getLeft();

	public abstract Dense<b> getRight();

}
