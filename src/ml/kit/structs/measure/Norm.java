package ml.kit.structs.measure;

public interface Norm<T,M extends Number> extends Metric<T,M> {

	T center();

}
