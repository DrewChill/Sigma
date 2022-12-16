package archive.relation.combinator;

import archive.relation.Op;
import ml.foundation.primitive.seq.TransformationCharacter;

public interface Combinator<a,b,c,result> extends Op<TransformationCharacter<b,c>,Op<a,result>> {}
