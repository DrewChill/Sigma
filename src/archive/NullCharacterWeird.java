package archive;

import ml.kit.primitive.num.Complex;
import ml.kit.primitive.num.Rational;
import ml.kit.primitive.num.measure.code.pkg.group.Action;
import ml.kit.primitive.num.measure.code.pkg.group.Group;

import java.util.Collection;
import java.util.Set;

public class NullCharacterWeird<point,domain extends Rational>
		implements
		Action<point,domain>,
		Group<point,domain,NullCharacterWeird<point,domain>>{



	//--------------------
	@Override
	public Number character() {
		return null;
	}

	@Override
	public Complex root() {
		return null;
	}

	@Override
	public Complex denominator() {
		return null;
	}
	//--------------------



	//--------------------
	@Override
	public Collection<? extends point> sources() {
		return null;
	}
	@Override
	public point getPoint() {
		return null;
	}
	//-------
	@Override
	public Collection<? extends NullCharacterWeird<point,domain>> encoding() {
		return null;
	}
	@Override
	public NullCharacterWeird<point,domain> origin() {
		return null;
	}
	@Override
	public domain stabilizer() {
		return null;
	}
	//-------
	@Override
	public Collection<? extends NullCharacterWeird<point,domain>> targets() {
		return null;
	}
	@Override
	public NullCharacterWeird<point,domain> getDomain() {
		return null;
	}
	//--------------------



	//--------------------
	@Override
	public Set<NullCharacterWeird<point,domain>> include(point observation) {
		return null;
	}

	@Override
	public Set<NullCharacterWeird<point,domain>> exclude(point observation) {
		return null;
	}

	@Override
	public Set<NullCharacterWeird<point,domain>> fibersFromKey(point key) {
		return null;
	}
	//--------------------



	//--------------------
	@Override
	public NullCharacterWeird<point,domain> distance(NullCharacterWeird<point,domain> from, NullCharacterWeird<point,domain> to) {
		return null;
	}

	@Override
	public NullCharacterWeird<point,domain> length(NullCharacterWeird<point,domain> object) {
		return null;
	}
	//--------------------

}
