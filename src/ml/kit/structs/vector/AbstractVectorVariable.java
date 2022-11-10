package ml.kit.structs.vector;

import ml.kit.identity.valuation.distribution.Distribution;
import archive.NumberValue;
import ml.kit.structs.dictionary.Entry;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class AbstractVectorVariable<Coefficient,Basis> implements VectorVariable<Coefficient,Basis> {
	@Override
	public Collection<Basis> sources() {
		return null;
	}

	@Override
	public Collection<NumberValue<? super Coefficient>> targets() {
		return null;
	}

	@Override
	public Map<Basis,NumberValue<? super Coefficient>> value() {
		return null;
	}

	@Override
	public Distribution<Basis> inc(Basis basis) {
		return null;
	}

	@Override
	public Distribution<Basis> dec(Basis basis) {
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
	public Iterator<Entry<Basis,NumberValue<? super Coefficient>>> iterator() {
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
	public boolean add(Entry<Basis,NumberValue<? super Coefficient>> basisNumberValueEntry) {
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
	public boolean addAll(Collection<? extends Entry<Basis,NumberValue<? super Coefficient>>> c) {
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

	//----------------------

	//----------------------


	//----------------------

	//----------------------


	//----------------------



	//----------------------












}
