package ml.kit.structs;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public interface Singleton<X> extends Set<X> {
	
	X element();
	default Set<X> internal(){
		return Collections.singleton(element());
	}

	//TODO: override all with the internal set methods
	@Override
	default int size() {
		return 0;
	}

	@Override
	default boolean isEmpty() {
		return false;
	}

	@Override
	default boolean contains(Object o) {
		return false;
	}

	@Override
	default Iterator<X> iterator() {
		return null;
	}

	@Override
	default Object[] toArray() {
		return new Object[0];
	}

	@Override
	default <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	default boolean add(X x) {
		return false;
	}

	@Override
	default boolean remove(Object o) {
		return false;
	}

	@Override
	default boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	default boolean addAll(Collection<? extends X> c) {
		return false;
	}

	@Override
	default boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	default boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	default void clear() {

	}
}
