package archive;


import ml.foundation.primitive.seq.TerminalCharacter;

public interface StringNode<g,cg extends TerminalCharacter<g>> extends TerminalCharacter<cg> {

	StringNode<g,cg> nextNode();

}
