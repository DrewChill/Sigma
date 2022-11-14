package ml.kit.primitive.num.measure.code.pkg.group;

import ml.kit.primitive.num.measure.code.Code;
import ml.kit.primitive.num.measure.code.pkg.Bundle;
import ml.kit.primitive.num.Rational;

import java.util.Set;

//I'm gonna throw up
public interface Group<g,s extends Rational,A extends Action<g,s>>
		extends
		Bundle<
				g,
				Group<
						? extends g,
						?,
						? extends Action<? extends g,?>>,
				A> {


	//------------------
	A orbit(); //the sum(/convolution?) of the tangent groups (the action from the origin to the sum of supergroups)

	Set<? extends Group<
			? extends g,
			?,
			? extends Action<? extends g,?>>> include(g observation);

	Set<? extends Group<
			? extends g,
			?,
			? extends Action<? extends g,?>>> exclude(g observation);

	default Code<g,A,Group<? extends g,?,? extends Action<? extends g,?>>> density() {
		return length(orbit());
	}
	//------------------

}
