package archive.relation.construction.composition;

import ml.kit.num.Complex;
import archive.relation.construction.Presentation;
import archive.relation.construction.Representation;
import archive.relation.Op;

public interface Functor<g,N extends Complex,h> extends Op<g,h> {

	Presentation<g,N> presentation();
	Representation<N,h> representation();

	@Override
	default h operate(g input) {
		return getCenter().represent(presentation().present(input));
	}

}
