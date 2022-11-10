package ml.kit.structs.vector;

import ml.kit.identity.valuation.distribution.Distribution;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class RandomVectorBasis<T> implements VectorVariable<T,T> {

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
	public Iterator<Scalar<T>> iterator() {
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
	public boolean add(Scalar<T> tScalar) {
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
	public boolean addAll(Collection<? extends Scalar<T>> c) {
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
	public Distribution<T> inc(T t) {
		return null;
	}

	@Override
	public Distribution<T> dec(T t) {
		return null;
	}

	@Override
	public Collection<T> sources() {
		return null;
	}

	@Override
	public Collection<Distribution<T>> targets() {
		return null;
	}

	@Override
	public Map<T,Distribution<T>> value() {
		return null;
	}

	//----------------------


}
