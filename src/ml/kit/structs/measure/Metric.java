package ml.kit.structs.measure;

import java.util.Comparator;

public interface Metric<T,d extends Number> extends Comparator<T> {

	d distance(T from, T to);

}
