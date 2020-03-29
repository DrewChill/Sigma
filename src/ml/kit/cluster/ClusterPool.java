package ml.kit.cluster;

import ml.kit.structs.item.Item;

public interface ClusterPool<T> {
	
	public Cluster<T> addItemToClusterPool(Item<T> item);

}
