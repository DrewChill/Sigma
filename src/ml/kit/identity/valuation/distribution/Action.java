package ml.kit.identity.valuation.distribution;

import ml.kit.structs.dictionary.Path;
import ml.kit.structs.num.Rational;

public interface Action<g,s extends Rational>
		extends Path<
		g,
		Group<
				? extends g,
				? extends s,
				? extends Action<? extends g,? extends s>>> {

	s stabilizer();

}
