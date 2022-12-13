package ml.kit.primitive.product.relation.combinator;

import ml.kit.primitive.product.relation.Op;
import ml.kit.primitive.seq.TransformationCharacter;

public interface Combinator<a,b,c,result> extends Op<TransformationCharacter<b,c>,Op<a,result>> {}
