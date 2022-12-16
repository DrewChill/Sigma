package archive.relation.construction;

import archive.relation.Op;
import ml.kit.num.Complex;

public interface Presentation<R,N extends Complex> extends Op<R,N> {

	N present(R representation);

}
