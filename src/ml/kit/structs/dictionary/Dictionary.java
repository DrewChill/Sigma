package ml.kit.structs.dictionary;

import ml.kit.identity.Identity;

import java.util.Set;

public interface Dictionary<K,V,E extends Entry<K,V>> extends Identity<K,E,V> {

	@Override
	Set<K> sources(); //parents
	Set<E> entriesFromKey(K key);

	@Override
	Set<V> targets(); //children
	Set<E> entriesToValue(V key);

}
