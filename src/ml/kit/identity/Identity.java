package ml.kit.identity;

import java.util.Collection;

public interface Identity<In,T,Out> extends Collection<T> {

	Collection<? extends In> sources(); //parents

	Collection<? extends Out> targets(); //children

}
