package ml.kit.symbol;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ml.kit.structs.asm.MLObject;
import ml.kit.structs.group.Context;
import ml.kit.structs.group.Synapse;
import ml.kit.symbol.entropy.LocalEntropy;
import ml.kit.symbol.structure.StructureInfo;

public class SymbolGenerator<T extends MLObject> {

	private Map<byte[], Symbol<T>> clusterForIndicator = new HashMap<>();
	private SymbolGenerator<T> inferredVocabulary = null;
	private Set<T> processQueue = new HashSet<>();
	private StructureInfo<T> model;
	private volatile int totalObservationCount = 0;
	private Context<T> currentContext = null;
	public volatile int id = 0;
	public volatile static int num = 0;

	public SymbolGenerator(StructureInfo<T> model) {
		this.id = num++;
		this.model = model;
	}
	
	public LocalEntropy<Symbol<T>> registerSynapse(Synapse<T> synapse){
		return model.createUpstreamConnection(synapse);
	}

	public void setContext(Context<T> context) {
		currentContext = context;
	}

	public void queueMLObject(T item) {
		synchronized (processQueue) {
			totalObservationCount++;
			processQueue.add(item);
		}
	}

	public Set<Symbol<T>> generate() {
		Set<Symbol<T>> symbols = new HashSet<>();
		Set<T> queueCopy = new HashSet<T>();
		synchronized (processQueue) {
			queueCopy.addAll(processQueue);
			processQueue.clear();
		}
		
		for (T item : queueCopy) {
			Symbol<T> symbol = model.getStructure().stimulate(item, totalObservationCount, currentContext.getContextSize());
			symbols.add(symbol);
			item.getSynapseForStructureId(id).reuptake(symbol);

			synchronized (clusterForIndicator) {
				if (!clusterForIndicator.containsKey(symbol.clusterIndicator))
					clusterForIndicator.put(symbol.clusterIndicator, symbol);
			}
		}

		return symbols;
	}

	public int totalItemsContributed() {
		int count = 0;
		for (Symbol<T> cluster : clusterForIndicator.values()) {
			count += cluster.clusterSize();
		}
		return count;
	}

	public Collection<Symbol<T>> allClusters() {
		synchronized (clusterForIndicator) {
			return clusterForIndicator.values();
		}
	}

	public Symbol<T> decodeBytes(byte[] encoded) {
		synchronized (clusterForIndicator) {
			if (clusterForIndicator.containsKey(encoded)) {
				return clusterForIndicator.get(encoded);
			} else {
				return null;
			}
		}
	}

	public SymbolGenerator<T> getNestedVocabulary() {
		return inferredVocabulary;
	}

}
