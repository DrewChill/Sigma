package archive.relation;

public abstract class Action<x,S,y> extends Relation<x,S,y> {

	abstract y operate(x x);

	abstract <extension,extCenter,
			centralProduct extends Relation<S,y,extCenter>>
	Action<x,centralProduct,extension> append(
					Action<y,extCenter,extension> action);

	abstract <prefix,preCenter,
			centralProduct extends Relation<preCenter,x,S>>
	Action<prefix,centralProduct,y> prepend(
			Action<prefix,preCenter,x> action);

}
