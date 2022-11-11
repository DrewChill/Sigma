package ml.kit.identity.valuation.distribution;

import ml.kit.identity.Code;
import ml.kit.structs.dictionary.Bundle;
import ml.kit.structs.num.Rational;

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
