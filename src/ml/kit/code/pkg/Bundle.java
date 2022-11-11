package ml.kit.code.pkg;

import ml.kit.code.Code;

import java.util.Set;

public interface Bundle<K,V,E extends Fiber<K,V>> extends Code<K,E,V> {

	Set<E> fibersFromKey(K key);

}
