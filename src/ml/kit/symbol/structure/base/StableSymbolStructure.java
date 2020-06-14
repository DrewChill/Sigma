package ml.kit.symbol.structure.base;

import java.util.HashMap;
import java.util.Map;

import ml.kit.structs.asm.MLObject;
import ml.kit.symbol.Symbol;
import ml.kit.symbol.structure.StructureInfo;
import ml.kit.symbol.structure.SymbolStructure;

public class StableSymbolStructure<T extends MLObject> extends SymbolStructure<T>{

	public StableSymbolStructure(StructureInfo<T> behavior) {
		super(behavior);
	}

	Map<T, Symbol<T>> clusterMap = new HashMap<>();
	
	@Override
	public Symbol<T> excite(T item, double vSize, int capacity) {
		return sample(item, vSize, capacity, 1.0);
	}

	@Override
	public Symbol<T> inhibit(T item, double vSize, int capacity) {
		return sample(item, vSize, capacity, 1.0);
	}
	
	public Symbol<T> sample(T item, double vSize, int capacity, double weightModifier) {
		Symbol<T> cluster = null;
		synchronized(clusterMap) {
			cluster = clusterMap.get(item);
			if(cluster == null) {
				cluster = createNewSymbol();
				clusterMap.put(item, cluster);
			}
			cluster.updateWeight(item, 1.0);
		}
		
		return cluster;
	}

}
