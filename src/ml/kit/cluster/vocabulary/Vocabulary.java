package ml.kit.cluster.vocabulary;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ml.kit.cluster.Symbol;
import ml.kit.cluster.SymbolStructure;
import ml.kit.structs.item.Stimulus;

public class Vocabulary<T> {

	private Map<byte[],Symbol<T>> clusterForIndicator = new HashMap<>();
	private Vocabulary<T> inferredVocabulary = null;
	private Set<Stimulus<T>> items = new HashSet<>();
	
	
	public void addItem(Stimulus<T> item){
		items.add(item);
	}
	
	public Vocabulary<T> clusterVocabulary(SymbolStructure<T> clusterPool){
		for(Stimulus<T> item : items) {
			Symbol<T> cluster = clusterPool.signalSymbolStructure(item);
			item.setAssignment(cluster);
			
			synchronized(clusterForIndicator) {
				if(!clusterForIndicator.containsKey(cluster.getIndicator()))
					clusterForIndicator.put(cluster.getIndicator(), cluster);
			}
		}
		
		return clusterForIndicator;
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
	
	public Vocabulary<T> getDerivedVocabulary(){
		return inferredVocabulary;
	}
	
}
