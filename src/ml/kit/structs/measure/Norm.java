package ml.kit.structs.measure;

public interface Norm<T,d extends Number> extends Metric<T,d> {

	T stabilizer(); //aka 0, aka origin, aka center

}
