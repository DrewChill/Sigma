package ml.kit.structs.dictionary;

import ml.kit.identity.Identity;

import java.util.Set;

public interface Dictionary<K,V,E extends Entry<K,V>> extends Identity<K,E,V> {

	Set<E> entriesFromKey(K key);

}
