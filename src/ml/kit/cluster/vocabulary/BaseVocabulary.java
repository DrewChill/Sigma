package ml.kit.cluster.vocabulary;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ml.kit.cluster.Symbol;
import ml.kit.cluster.SymbolStructure;
import ml.kit.structs.item.Stimulus;

public class BaseVocabulary<T extends Serializable> {
	
	private SymbolStructure<T> clusterPool;
	private Map<byte[], Symbol<T>> clusterForIndicator;
	private Vocabulary<T> derivedVocabulary;
	
	
	public BaseVocabulary(SymbolStructure<T> clusterPool) {
		this.clusterPool = clusterPool;
		this.clusterForIndicator = new HashMap<>();
		this.derivedVocabulary = null;
	}
	
	public void link(SymbolStructure<T> outPool) {
		this.derivedVocabulary = new Vocabulary<T>(outPool);
	}
	
	public Symbol<T> clusterItem(Stimulus<T> item){
		Symbol<T> cluster = clusterPool.signalSymbolStructure(item);
		item.setAssignment(cluster);
		
		synchronized(clusterForIndicator) {
			if(!clusterForIndicator.containsKey(cluster.getIndicator()))
				clusterForIndicator.put(cluster.getIndicator(), cluster);
		}
			
		return cluster;
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
		return derivedVocabulary;
	}
	
	public void addObjectToVocabulary(T obj) {
		Stimulus<T> item = new Stimulus<T>(obj, null);
		clusterItem(item);
	}
	

}
