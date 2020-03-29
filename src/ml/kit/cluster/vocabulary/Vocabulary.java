package ml.kit.cluster.vocabulary;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ml.kit.cluster.Cluster;
import ml.kit.cluster.ClusterPool;
import ml.kit.structs.item.Item;

public class Vocabulary<T> {

	private ClusterPool<T> clusterPool;
	private Map<byte[],Cluster<T>> clusterForIndicator;
	private Vocabulary<T> derivedVocabulary;
	
	
	public Vocabulary(ClusterPool<T> clusterPool) {
		this.clusterPool = clusterPool;
		this.clusterForIndicator = new HashMap<>();
		this.derivedVocabulary = null;
	}
	
	public Vocabulary(ClusterPool<T> inPool, ClusterPool<T> outPool) {
		this(inPool);
		this.derivedVocabulary = new Vocabulary<T>(outPool);
	}
	
	public Cluster<T> clusterItem(Item<T> item){
		Cluster<T> cluster = clusterPool.addItemToClusterPool(item);
		item.setAssignment(cluster);
		
		synchronized(clusterForIndicator) {
			if(!clusterForIndicator.containsKey(cluster.getIndicator()))
				clusterForIndicator.put(cluster.getIndicator(), cluster);
		}
			
		return cluster;
	}
	
	public int totalItemsContributed() {
		int count = 0;
		for(Cluster<T> cluster : clusterForIndicator.values()) {
			count += cluster.clusterSize();
		}
		return count;
	}
	
	public Collection<Cluster<T>> allClusters(){
		synchronized(clusterForIndicator) {
			return clusterForIndicator.values();
		}
	}
	
	public Cluster<T> decodeBytes(byte[] encoded){
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
	
}
