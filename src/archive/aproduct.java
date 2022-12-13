package archive;

import ml.kit.primitive.LeftCharacter;
import ml.kit.primitive.RightCharacter;

public class aproduct<x,y> implements LeftCharacter<x>, RightCharacter<y> {
	@Override
	public x getLeft() {
		return null;
	}

	@Override
	public y getRight() {
		return null;
	}
}
