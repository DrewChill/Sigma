package archive.str.ch.action;

import ml.foundation.primitive.Dense;
import ml.foundation.complex.topo.Closed;

public abstract class RightAction<b,c> extends Closed<Dense<b>,c> {

	public abstract Dense<b> getLeft();

	public abstract c getRight();

}
