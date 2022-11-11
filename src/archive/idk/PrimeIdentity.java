package archive.idk;

import ml.kit.identity.Code;

import java.util.Collection;
import java.util.List;

public class PrimeIdentity implements Code<Object,Object> {

	private final Number value;

	public PrimeIdentity(Number value) {
		this.value = value;
	}

	@Override
	public Number identifier() {
		return value;
	}

	@Override
	public Collection<Object> sources() {
		return List.of();
	}

	@Override
	public Collection<Object> targets() {
		return List.of();
	}
}
