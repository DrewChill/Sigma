package ml.kit.identity;

import java.util.Collection;

public interface Identity<In,T,Out> extends Collection<T> {

	Collection<In> sources(); //parents

	Collection<Out> targets(); //children

}
