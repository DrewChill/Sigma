package archive.read;

import ml.kit.primitive.str.TerminalCharacter;

public interface Enumerator<g> extends TerminalCharacter<g> {

	g enumeration();

}
