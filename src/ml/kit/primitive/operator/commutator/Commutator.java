package ml.kit.primitive.operator.commutator;

import ml.kit.primitive.product.DisjointProduct;
import ml.kit.primitive.operator.Mapping;

public interface Commutator<g,h> extends Mapping<DisjointProduct<g,h>,DisjointProduct<h,g>> {}
