package ml.kit.structs.dictionary;

import ml.kit.identity.Code;

import java.util.Set;

public interface Bundle<K,V,E extends Path<K,V>> extends Code<K,E,V> {

	Set<E> fibersFromKey(K key);

}
