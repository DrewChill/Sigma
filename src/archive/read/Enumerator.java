package archive.read;

import ml.foundation.primitive.seq.TerminalCharacter;

public interface Enumerator<g> extends TerminalCharacter<g> {

	g enumeration();

}
