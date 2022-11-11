package ml.kit.code.pkg.group;

import ml.kit.code.Code;
import ml.kit.code.pkg.Bundle;
import ml.kit.primitive.num.Rational;

import java.util.Set;

//I'm gonna throw up
public interface Group<g,s extends Rational,A extends Action<g,s>>
		extends
		Bundle<
				g,
				Group<
						? extends g,
						? extends s,
						? extends Action<? extends g,? extends s>>,
				A> {


	//------------------
	A orbit(); //the sum(/convolution?) of the tangent groups (the action from the origin to the sum of supergroups)

	Set<? extends Group<
			g,
			? extends s,
			? extends Action<g,? extends s>>> include(g observation);

	Set<? extends Group<
			g,
			? extends s,
			? extends Action<g,? extends s>>> exclude(g observation);

	default Code<g,A,Group<? extends g,? extends s,? extends Action<? extends g,? extends s>>> density() {
		return length(orbit());
	}
	//------------------

}
