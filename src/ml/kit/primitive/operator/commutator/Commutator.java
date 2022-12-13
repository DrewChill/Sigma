package ml.kit.primitive.operator.commutator;

import ml.kit.primitive.product.DisjointProduct;
import ml.kit.primitive.operator.Op;

public interface Commutator<g,h> extends Op<DisjointProduct<g,h>,DisjointProduct<h,g>> {}
