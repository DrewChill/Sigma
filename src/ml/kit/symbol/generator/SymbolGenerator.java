package ml.kit.symbol.generator;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ml.kit.structs.asm.MLObject;
import ml.kit.symbol.Symbol;
import ml.kit.symbol.structure.SymbolStructure;

public class SymbolGenerator<T extends MLObject> {

	private Map<byte[],Symbol<T>> clusterForIndicator = new HashMap<>();
	private SymbolGenerator<T> inferredVocabulary = null;
	private Set<T> processQueue = new HashSet<>();
	SymbolStructure<T> model;
	
	public SymbolGenerator(SymbolStructure<T> model) {
		this.model = model;
	}
	
	
	public void queueMLObject(T item){
		synchronized(processQueue) {
			processQueue.add(item);
		}
	}
	
	public Set<Symbol<T>> generate(){
		Set<Symbol<T>> symbols = new HashSet<>();
		Set<T> queueCopy = new HashSet<T>();
		synchronized(processQueue) {
			queueCopy.addAll(processQueue);
			processQueue.clear();
		}
		for(T item : queueCopy) {
			Symbol<T> symbol = model.excite(item);
			symbols.add(symbol);
			
			synchronized(clusterForIndicator) {
				if(!clusterForIndicator.containsKey(symbol.clusterIndicator))
					clusterForIndicator.put(symbol.clusterIndicator, symbol);
			}
		}
		
		return symbols;
	}
	
	public int totalItemsContributed() {
		int count = 0;
		for(Symbol<T> cluster : clusterForIndicator.values()) {
			count += cluster.clusterSize();
		}
		return count;
	}
	
	public Collection<Symbol<T>> allClusters(){
		synchronized(clusterForIndicator) {
			return clusterForIndicator.values();
		}
	}
	
	public Symbol<T> decodeBytes(byte[] encoded){
		synchronized(clusterForIndicator) {
			if(clusterForIndicator.containsKey(encoded)) {
				return clusterForIndicator.get(encoded);
			}else{
				return null;
			}
		}
	}
	
	public SymbolGenerator<T> getNestedVocabulary(){
		return inferredVocabulary;
	}
	
}
