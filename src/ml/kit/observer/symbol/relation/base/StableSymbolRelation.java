package ml.kit.observer.symbol.relation.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import ml.kit.structs.asm.MLObject;
import ml.kit.observer.symbol.Symbol;
import ml.kit.observer.Observer;
import ml.kit.observer.symbol.relation.SymbolRelation;

public class StableSymbolRelation<T extends MLObject> extends SymbolRelation<T> {
	
	private Random r = new Random();

	public StableSymbolRelation(Observer<T> behavior) {
		super(behavior);
	}

	Map<T, Symbol<T>> clusterMap = new HashMap<>();
	
	@Override
	public Symbol<T> excite(T item, double vSize, int capacity) {
		return sample(item, vSize, capacity, 1.0);
	}

	@Override
	public T inhibit(double vSize, int capacity) {
		return sampleAndRemove(vSize, capacity, -1.0);
	}
	
	public T sampleAndRemove(double vSize, int capacity, double weightModifier) {
		int clusterIndex = (int)Math.floor(r.nextDouble() * clusterMap.size());
		Symbol<T> symbol = (Symbol<T>)clusterMap.values().toArray()[clusterIndex];
		T ret = symbol.sampleItemFromCluster();
		symbol.updateWeight(ret, weightModifier);
		
		return ret;
	}
	
	public Symbol<T> sample(T item, double vSize, int capacity, double weightModifier) {
		Symbol<T> cluster = null;
		synchronized(clusterMap) {
			cluster = clusterMap.get(item);
			if(cluster == null) {
				cluster = createNewSymbol();
				clusterMap.put(item, cluster);
			}
			cluster.updateWeight(item, weightModifier);
		}
		
		return cluster;
	}

}
