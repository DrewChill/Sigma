package ml.kit.symbol;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ml.kit.structs.asm.MLObject;
import ml.kit.structs.group.Context;
import ml.kit.structs.group.Synapse;
import ml.kit.symbol.entropy.LocalEntropy;
import ml.kit.symbol.structure.StructureInfo;

public class SymbolGenerator<T extends MLObject> {

	private List<Symbol<T>> allClusters = new ArrayList<>();
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
		System.out.println("processing...");
		Set<Symbol<T>> symbols = new HashSet<>();
		Set<T> queueCopy = new HashSet<T>();
		synchronized (processQueue) {
			queueCopy.addAll(processQueue);
			processQueue.clear();
		}
		
		for (T item : queueCopy) {
			Symbol<T> symbol = model.getStructure().stimulate(item, totalObservationCount, currentContext.getContextSize());
			symbols.add(symbol);
			Synapse<? extends MLObject> contributor = item.getSynapseForStructureId(id);
			contributor.reuptake(symbol);
			symbol.addContributor(contributor);

			synchronized (allClusters) {
				if (!allClusters.contains(symbol))
					allClusters.add(symbol);
			}
		}
		System.out.println("done...");
		return symbols;
	}
	
	public Collection<Symbol<T>> postProcess(int iterations) {
		for(int i=0; i<iterations; i++) {
			T removed = model.getStructure().decay(totalObservationCount, currentContext.getContextSize());
			if(removed != null) {
				Symbol<T> symbol = model.getStructure().stimulate(removed, totalObservationCount - 1, currentContext.getContextSize());
				synchronized (allClusters) {
					if (!allClusters.contains(symbol))
						allClusters.add(symbol);
				}
			}
		}
		return model.getStructure().allClusters;
	}
	
	public Symbol<T> sample(T data){
		return model.getStructure().stimulate(data, totalObservationCount, currentContext.getContextSize());
	}

	public int totalItemsContributed() {
		int count = 0;
		for (Symbol<T> cluster : allClusters) {
			count += cluster.clusterSize();
		}
		return count;
	}

	public Collection<Symbol<T>> allClusters() {
		synchronized (allClusters) {
			return allClusters;
		}
	}

	public Symbol<T> decodeBytes(byte[] encoded) {
		return null;
	}

	public SymbolGenerator<T> getNestedVocabulary() {
		return inferredVocabulary;
	}

}
