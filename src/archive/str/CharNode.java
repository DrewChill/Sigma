package archive.str;

import ml.foundation.primitive.d.Dense;
import archive.str.ch.action.LeftAction;
import archive.str.ch.action.RightAction;

public abstract class CharNode<a,b,c> extends TopologicalElement<a,Dense<b>,c> {

	public abstract Dense<b> image();

	public abstract LeftAction<a,b> getLeft();

	public abstract RightAction<b,c> getRight();

}
