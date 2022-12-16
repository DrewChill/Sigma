package archive.relation.construction;

import archive.relation.Op;
import ml.num.Complex;

public interface Representation<N extends Complex,R> extends Op<N,R> {

	R represent(N num);

}
