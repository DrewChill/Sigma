package ml.kit.primitive.seq;

import ml.kit.primitive.Nothing;
import ml.kit.primitive.Something;

public interface TerminalCharacter<c> extends Something<c> {

	Nothing complex();

}
