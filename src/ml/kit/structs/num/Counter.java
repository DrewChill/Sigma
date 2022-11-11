package ml.kit.structs.num;

import ml.kit.identity.valuation.distribution.Conjugate;
import ml.kit.identity.valuation.distribution.Distribution;
import ml.kit.structs.Singleton;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class Counter<T,d extends Number>
		extends Distribution<T,d,Counter<T,d>>
		implements Conjugate<T,d>,Count<T,d> {


	public Counter(T center) {
		super(center);
	}

	@Override
	public Set<Distribution<T,? extends d,? extends Conjugate<T,? extends d>>> inc(T observation) {
		return null;
	}

	@Override
	public Counter<T,d> dec(T observation) {
		return null;
	}

	@Override
	public Counter<T,d> element() {
		return null;
	}

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
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {

	}

	@Override
	public d distance() {
		return null;
	}

	@Override
	public Set<T> sources() {
		return null;
	}

	@Override
	public Set<Counter<T,d>> entriesFromKey(T key) {
		return null;
	}

	@Override
	public Set<Distribution<T,? extends d,? extends Conjugate<T,? extends d>>> targets() {
		return null;
	}

	@Override
	public Set<Counter<T,d>> entriesToValue(Distribution<T,? extends d,? extends Conjugate<T,? extends d>> key) {
		return null;
	}

	@Override
	public T getKey() {
		return null;
	}

	@Override
	public Distribution<T,? extends d,? extends Conjugate<T,? extends d>> getValue() {
		return null;
	}

	@Override
	public d distance(T from, T to) {
		return null;
	}
}
