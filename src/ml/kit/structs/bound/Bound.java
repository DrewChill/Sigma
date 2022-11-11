package ml.kit.structs.bound;

import ml.kit.identity.Code;

public interface Bound<T> {

	Code identity();

	T lower();
	default boolean hasLower(){
		return lower() != null;
	}

	T upper();
	default boolean hasUpper(){
		return upper() != null;
	}

	boolean containsValue(T value);

	Bound<T> intersection(Bound<T> otherBound);

}
