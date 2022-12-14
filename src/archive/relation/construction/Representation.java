package archive.relation.construction;

import archive.relation.Op;
import ml.kit.primitive.num.Complex;

public interface Representation<N extends Complex,R> extends Op<N,R> {

	R represent(N num);

}
