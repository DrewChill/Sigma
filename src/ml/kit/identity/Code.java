package ml.kit.identity;

import ml.kit.structs.measure.Metric;
import java.util.Collection;

public interface Code<In,Bit,Out> extends Metric<Bit,Code<In,Bit,Out>> {

	Collection<? extends In> sources(); //parents

	Collection<? extends Bit> encoding();

	Collection<? extends Out> targets(); //children

}
