package ml.kit.primitive.seq;


public interface OperationalCharacter<b,c> extends TerminalCharacter<b> {

	@Override
	TerminalCharacter<c> complex();

}
