package ml.kit.identity.valuation;

import ml.kit.identity.Code;

public interface Valuation<In,T,V,Out> extends Code<In,T,Out> {

	V value();

}
