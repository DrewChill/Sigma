package archive.read;

import ml.kit.primitive.seq.TerminalCharacter;

public interface Enumerator<g> extends TerminalCharacter<g> {

	g enumeration();

}
