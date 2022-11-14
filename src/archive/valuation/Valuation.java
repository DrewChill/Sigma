package archive.valuation;

import ml.kit.primitive.num.measure.code.Code;

public interface Valuation<In,T,V,Out> extends Code<In,T,Out> {

	V value();

}
