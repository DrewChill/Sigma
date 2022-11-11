package ml.kit.code.pkg.group;

import ml.kit.code.pkg.Fiber;
import ml.kit.primitive.num.Rational;

public interface Action<g,s extends Rational>
		extends Fiber<
				g,
				Group<
						? extends g,
						? extends s,
						? extends Action<? extends g,? extends s>>> {

	s stabilizer();

}
