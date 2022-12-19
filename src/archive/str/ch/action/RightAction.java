package archive.str.ch.action;

import ml.foundation.primitive.d.Dense;
import ml.foundation.primitive.d.Closed;

public abstract class RightAction<b,c> extends Closed<Dense<b>,c> {

	public abstract Dense<b> getLeft();

	public abstract c getRight();

}
