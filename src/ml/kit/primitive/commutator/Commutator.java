package ml.kit.primitive.commutator;

import ml.kit.primitive.chiral.Product;
import ml.kit.primitive.operator.Operator;

public interface Commutator<g,h> extends Operator<Product<g,h>,Product<h,g>> {}
