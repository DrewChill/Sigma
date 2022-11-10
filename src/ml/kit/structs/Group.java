package ml.kit.structs;

import ml.kit.identity.Identity;
import ml.kit.structs.bound.BoundCollection;

public interface Group<T> {

	T interpret(Identity id);

	BoundCollection<T> bounds();

}
