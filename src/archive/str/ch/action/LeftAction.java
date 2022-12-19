package archive.str.ch.action;

import ml.foundation.primitive.d.Dense;
import ml.foundation.primitive.d.Closed;

public abstract class LeftAction<a,b> extends Closed<a,Dense<b>> {

	public abstract a getLeft();

	public abstract Dense<b> getRight();

}
