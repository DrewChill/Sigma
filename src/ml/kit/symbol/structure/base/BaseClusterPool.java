package ml.kit.symbol.structure.base;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import ml.kit.structs.item.Stimulus;
import ml.kit.symbol.Symbol;
import ml.kit.symbol.indicator.BaseIndicatorGenerator;
import ml.kit.symbol.structure.SymbolStructure;

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
