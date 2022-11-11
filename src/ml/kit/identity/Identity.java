package ml.kit.identity;

import ml.kit.structs.measure.Metric;
import java.util.Collection;

public interface Identity<In,T,Out> extends Metric<T,Identity<In,T,Out>> {

	Collection<? extends In> sources(); //parents

	Collection<T> encoding();

	Collection<? extends Out> targets(); //children

}
