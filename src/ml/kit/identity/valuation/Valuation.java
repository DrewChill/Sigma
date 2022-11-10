package ml.kit.identity.valuation;

import ml.kit.identity.Identity;

public interface Valuation<In,T,V,Out> extends Identity<In,T,Out> {

	V value();

}
