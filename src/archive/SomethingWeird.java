package archive;

import ml.kit.primitive.num.number;
import ml.kit.primitive.num.Rational;
import ml.kit.primitive.num.measure.code.pkg.group.Action;
import ml.kit.primitive.num.measure.code.pkg.group.Group;

import java.util.Collection;
import java.util.Set;

public class SomethingWeird<point,domain extends Rational>
		implements
		Action<point,domain>,
		Group<point,domain,SomethingWeird<point,domain>>{



	//--------------------
	@Override
	public Number real() {
		return null;
	}

	@Override
	public number complex() {
		return null;
	}

	@Override
	public number denominator() {
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
	public Collection<? extends SomethingWeird<point,domain>> encoding() {
		return null;
	}
	@Override
	public SomethingWeird<point,domain> origin() {
		return null;
	}
	@Override
	public domain stabilizer() {
		return null;
	}
	//-------
	@Override
	public Collection<? extends SomethingWeird<point,domain>> targets() {
		return null;
	}
	@Override
	public SomethingWeird<point,domain> getDomain() {
		return null;
	}
	//--------------------



	//--------------------
	@Override
	public Set<SomethingWeird<point,domain>> include(point observation) {
		return null;
	}

	@Override
	public Set<SomethingWeird<point,domain>> exclude(point observation) {
		return null;
	}

	@Override
	public Set<SomethingWeird<point,domain>> fibersFromKey(point key) {
		return null;
	}
	//--------------------



	//--------------------
	@Override
	public SomethingWeird<point,domain> distance(SomethingWeird<point,domain> from, SomethingWeird<point,domain> to) {
		return null;
	}

	@Override
	public SomethingWeird<point,domain> length(SomethingWeird<point,domain> object) {
		return null;
	}
	//--------------------

}
