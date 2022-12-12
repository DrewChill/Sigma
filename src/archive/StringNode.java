package archive;


import ml.kit.primitive.seq.TerminalCharacter;

public interface StringNode<g,cg extends TerminalCharacter<g>> extends TerminalCharacter<cg> {

	StringNode<g,cg> nextNode();

}
