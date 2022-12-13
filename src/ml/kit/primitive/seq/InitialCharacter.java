package ml.kit.primitive.seq;


public interface InitialCharacter<a,b,c> extends OperationalCharacter<a,b> {

	@Override
	OperationalCharacter<b,c> complex();

}
