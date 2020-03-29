package ml.kit.cluster.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import ml.kit.cluster.Cluster;
import ml.kit.cluster.ClusterPool;
import ml.kit.cluster.indicator.BaseIndicatorGenerator;
import ml.kit.structs.item.Item;

public class BaseClusterPool<T extends Serializable> implements ClusterPool<T>{

	Map<T, BaseCluster<T>> clusterMap = new HashMap<>();
	
	@Override
	public Cluster<T> addItemToClusterPool(Item<T> item) {
		BaseCluster<T> cluster = null;
		synchronized(clusterMap) {
			cluster = clusterMap.get(item.getValue());
			if(cluster == null) {
				cluster = new BaseCluster<T>(new BaseIndicatorGenerator<T>());
				clusterMap.put(item.getValue(), cluster);
			}
			cluster.addOrRejectItem(item);
		}
		return cluster;
	}

}
