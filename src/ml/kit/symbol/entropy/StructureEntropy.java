package ml.kit.symbol.entropy;

import java.util.HashSet;
import java.util.Set;

import ml.kit.structs.asm.MLObject;
import ml.kit.symbol.Symbol;

public class StructureEntropy<T extends MLObject, S extends Symbol<T>> {
	
	Set<LocalEntropy<S>> synapticEntropies = new HashSet<>();
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
	
	public LocalEntropy<S> spawnSynapticEntropy() {
		LocalEntropy<S> newEntropy = new LocalEntropy<S>();
		synapticEntropies.add(newEntropy);
		return newEntropy;
	}

}
