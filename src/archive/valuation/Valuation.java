package archive.valuation;

import ml.kit.code.Code;

public interface Valuation<In,T,V,Out> extends Code<In,T,Out> {

	V value();

}
