package ml.kit.observer.history;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ml.kit.structs.asm.MLObject;
import ml.kit.structs.group.Intraface;
import ml.kit.observer.symbol.Symbol;

public class RelationHistory<T extends MLObject, S extends Symbol<T>> {
	
	Map<Intraface<T>,ObservationHistory<S>> synapticEntropies = new HashMap<>();
	Set<ObservationHistory<T>> symbolicEntropies = new HashSet<>();
	int id = 0;
	
	public RelationHistory() {};
	
	public RelationHistory(RelationHistory<T, ?> upstreamEntropy) {
		//TODO
	}
	
	public ObservationHistory<T> spawnSymbolicEntropy() {
		ObservationHistory<T> newEntropy = new ObservationHistory<T>();
		symbolicEntropies.add(newEntropy);
		return newEntropy;
	}
	
	public ObservationHistory<S> spawnSynapticEntropy(Intraface<T> intraface) {
		ObservationHistory<S> newEntropy = new ObservationHistory<S>();
		synapticEntropies.put(intraface, newEntropy);
		return newEntropy;
	}
	
	public Set<Intraface<T>> getSynapses(){
		return synapticEntropies.keySet();
	}

}
