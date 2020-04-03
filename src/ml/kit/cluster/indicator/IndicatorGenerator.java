package ml.kit.cluster.indicator;

import ml.kit.cluster.Symbol;

public interface IndicatorGenerator<T> {

	public byte[] getLabelForCluster(Symbol<T> cluster);
	
}
