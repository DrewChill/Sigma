package ml.kit.symbol.entropy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ml.kit.structs.asm.MLObject;
import ml.kit.structs.group.Synapse;
import ml.kit.symbol.Symbol;

public class StructureEntropy<T extends MLObject, S extends Symbol<T>> {
	
	Map<Synapse<T>, LocalEntropy<S>> synapticEntropies = new HashMap<>();
	Set<LocalEntropy<T>> symbolicEntropies = new HashSet<>();
	int id = 0;
	
	public StructureEntropy() {};
	
	public StructureEntropy(StructureEntropy<T, ?> upstreamEntropy) {
		//TODO
	}
	
	public LocalEntropy<T> spawnSymbolicEntropy() {
		LocalEntropy<T> newEntropy = new LocalEntropy<T>();
		symbolicEntropies.add(newEntropy);
		return newEntropy;
	}
	
	public LocalEntropy<S> spawnSynapticEntropy(Synapse<T> synapse) {
		LocalEntropy<S> newEntropy = new LocalEntropy<S>();
		synapticEntropies.put(synapse, newEntropy);
		return newEntropy;
	}
	
	public Set<Synapse<T>> getSynapses(){
		return synapticEntropies.keySet();
	}

}
