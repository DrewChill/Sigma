package ml.kit.cluster.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import ml.kit.cluster.Symbol;
import ml.kit.cluster.SymbolStructure;
import ml.kit.cluster.indicator.BaseIndicatorGenerator;
import ml.kit.structs.item.Stimulus;

public class BaseClusterPool<T extends Serializable> implements SymbolStructure<T>{

	Map<T, BaseCluster<T>> clusterMap = new HashMap<>();
	
	@Override
	public Symbol<T> signalSymbolStructure(Stimulus<T> item) {
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
