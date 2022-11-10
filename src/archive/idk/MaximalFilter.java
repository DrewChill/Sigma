package archive.idk;

import java.util.Collection;
import java.util.List;

public class MaximalFilter<R> implements Filter<Object,R> {

	private final Number value;
	private final Collection<R> relations;

	protected MaximalFilter(Number value, Collection<R> relations) {
		this.value = value;
		this.relations = relations;
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
	public Collection<R> targets() {
		return relations;
	}

}
