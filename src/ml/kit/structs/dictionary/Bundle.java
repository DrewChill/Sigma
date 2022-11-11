package ml.kit.structs.dictionary;

import ml.kit.identity.Identity;

import java.util.Set;

public interface Bundle<K,V,E extends Path<K,V>> extends Identity<K,E,V> {

	Set<E> fibersFromKey(K key);

}
