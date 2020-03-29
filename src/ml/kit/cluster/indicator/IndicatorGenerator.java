package ml.kit.cluster.indicator;

import ml.kit.cluster.Cluster;

public interface IndicatorGenerator<T> {

	public byte[] getLabelForCluster(Cluster<T> cluster);
	
}
