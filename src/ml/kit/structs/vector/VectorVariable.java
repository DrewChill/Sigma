package ml.kit.structs.vector;

import ml.kit.identity.valuation.distribution.Distribution;
public interface VectorVariable<Coefficient,Basis> extends Vector<Coefficient,Basis> {

	Distribution<Coefficient> inc(Basis basis);

	Distribution<Coefficient> dec(Basis basis);

}
