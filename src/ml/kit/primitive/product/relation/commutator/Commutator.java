package ml.kit.primitive.product.relation.commutator;

import ml.kit.primitive.product.DisjointRelation;
import ml.kit.primitive.product.relation.Op;

public interface Commutator<g,h> extends Op<DisjointRelation<g,h>,DisjointRelation<h,g>> {}
