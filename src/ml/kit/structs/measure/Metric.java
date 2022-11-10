package ml.kit.structs.measure;

import java.util.Comparator;

public interface Metric<T,M extends Number> extends Comparator<T> {

	M distance(T from, T to);

}
