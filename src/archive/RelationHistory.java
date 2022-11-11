package archive;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import archive.asm.Observable;

public class RelationHistory<T extends Observable, S extends StochasticSymbol<T>> {
	
	Map<AbstractEmitter<T>,ObservationHistory<S>> synapticEntropies = new HashMap<>();
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
	
	public ObservationHistory<S> spawnSynapticEntropy(AbstractEmitter<T> intraface) {
		ObservationHistory<S> newEntropy = new ObservationHistory<S>();
		synapticEntropies.put(intraface, newEntropy);
		return newEntropy;
	}
	
	public Set<AbstractEmitter<T>> getSynapses(){
		return synapticEntropies.keySet();
	}

}
