package ml.kit.observer.symbol.relation.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import archive.asm.Observable;
import archive.StochasticSymbol;
import ml.kit.observer.AbstractObserver;
import ml.kit.observer.symbol.relation.SymbolRelation;

public class StableSymbolRelation<T extends Observable> extends SymbolRelation<T> {
	
	private Random r = new Random();

	public StableSymbolRelation(AbstractObserver<T> behavior) {
		super(behavior);
	}

	Map<T,StochasticSymbol<T>> clusterMap = new HashMap<>();
	
	@Override
	public StochasticSymbol<T> excite(T item, double vSize, int capacity) {
		return sample(item, vSize, capacity, 1.0);
	}

	@Override
	public T inhibit(double vSize, int capacity) {
		return sampleAndRemove(vSize, capacity, -1.0);
	}
	
	public T sampleAndRemove(double vSize, int capacity, double weightModifier) {
		int clusterIndex = (int)Math.floor(r.nextDouble() * clusterMap.size());
		StochasticSymbol<T> symbol = (StochasticSymbol<T>)clusterMap.values().toArray()[clusterIndex];
		T ret = symbol.sample();
		symbol.updateWeight(ret, weightModifier);
		
		return ret;
	}
	
	public StochasticSymbol<T> sample(T item, double vSize, int capacity, double weightModifier) {
		StochasticSymbol<T> cluster = null;
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
