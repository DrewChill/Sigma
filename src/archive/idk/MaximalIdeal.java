package archive.idk;

import java.util.Collection;
import java.util.List;

public class MaximalIdeal<C> implements Ideal<C,Object> {

	private final Number value;
	private final Collection<C> contexts;

	protected MaximalIdeal(Number value, Collection<C> contexts) {
		this.value = value;
		this.contexts = contexts;
	}

	@Override
	public Number identifier() {
		return value;
	}

	@Override
	public Collection<C> sources() {
		return contexts;
	}

	@Override
	public Collection<Object> targets() {
		return List.of();
	}

}
