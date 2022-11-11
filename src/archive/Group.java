package archive;

import ml.kit.code.Code;
import archive.bound.BoundCollection;

public interface Group<T> {

	T interpret(Code id);

	BoundCollection<T> bounds();

}
