package ml.num.measure.code.pkg;

import ml.num.measure.code.Code;

import java.util.Set;

public interface Bundle<P,D,F extends Fiber<P,D>> extends Code<P,F,D> {

	Set<F> fibersFromKey(P key);

}