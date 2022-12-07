package ml.kit.primitive.str;

import ml.kit.primitive.commutative.SymProduct;

public interface Reader<g> {

	<result> result read(g obj, SymProduct<g,result> translator);

}
