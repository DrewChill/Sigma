package ml.num.measure.code;

import ml.num.measure.Metric;
import java.util.Collection;

public interface Code<In,Bit,Out> extends Metric<Bit,Code<In,Bit,Out>> {

	Collection<? extends In> sources(); //parents

	Collection<? extends Bit> encoding();

	Collection<? extends Out> targets(); //children

}