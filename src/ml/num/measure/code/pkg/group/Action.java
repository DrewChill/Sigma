package ml.num.measure.code.pkg.group;

import ml.num.measure.code.pkg.Fiber;
import ml.num.Rational;

public interface Action<g,s extends Rational>
		extends Fiber<
				g,
				Group<
						? extends g,
						?,
						? extends Action<? extends g,?>>> {

	s stabilizer();

}
