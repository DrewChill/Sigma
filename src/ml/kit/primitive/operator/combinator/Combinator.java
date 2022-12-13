package ml.kit.primitive.operator.combinator;

import ml.kit.primitive.operator.Op;
import ml.kit.primitive.seq.OperationalCharacter;

public interface Combinator<a,b,c,result> extends Op<OperationalCharacter<b,c>,Op<a,result>> {}
