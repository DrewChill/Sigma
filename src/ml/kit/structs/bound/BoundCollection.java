package ml.kit.structs.bound;

import java.util.Collection;

public interface BoundCollection<T> extends Collection<Bound<T>> {

	BoundGroup<T> basis(); //maximal sized bounds (intersecting bounds "join")

	BoundGroup<T> closure();//minimal sized bounds (intersecting bounds "meet")

}
