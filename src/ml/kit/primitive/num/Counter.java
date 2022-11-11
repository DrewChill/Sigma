package ml.kit.primitive.num;

import ml.kit.code.pkg.group.Action;
import ml.kit.code.pkg.group.Group;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class Counter<T,d extends Rational>
		implements
		Group<T,d,Counter<T,d>>,
		Action<T,d>,
		Set<Counter<T,d>> {

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Iterator<Counter<T,d>> iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return new Object[0];
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean add(Counter<T,d> tdCounter) {
		return false;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Counter<T,d>> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {

	}

	@Override
	public Collection<? extends T> sources() {
		return null;
	}

	@Override
	public Collection<? extends Counter<T,d>> encoding() {
		return null;
	}

	@Override
	public Collection<Counter<T,d>> targets() {
		return null;
	}

	@Override
	public d stabilizer() {
		return null;
	}

	@Override
	public Counter<T,d> orbit() {
		return null;
	}

	@Override
	public Set<Counter<T,d>> include(T observation) {
		return null;
	}

	@Override
	public Set<Counter<T,d>> exclude(T observation) {
		return null;
	}

	@Override
	public Set<Counter<T,d>> fibersFromKey(T key) {
		return null;
	}

	@Override
	public T getKey() {
		return null;
	}

	@Override
	public Counter<T,d> getValue() {
		return null;
	}

	@Override
	public Counter<T,d> origin() {
		return null;
	}

	@Override
	public Counter<T,d> distance(Counter<T,d> from, Counter<T,d> to) {
		return null;
	}

	@Override
	public Number value() {
		return null;
	}

	@Override
	public AbstractNumber real() {
		return null;
	}

	@Override
	public AbstractNumber denominator() {
		return null;
	}
}
