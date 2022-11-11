package ml.kit.structs;

import ml.kit.identity.Code;
import ml.kit.structs.bound.BoundCollection;

public interface Group<T> {

	T interpret(Code id);

	BoundCollection<T> bounds();

}
