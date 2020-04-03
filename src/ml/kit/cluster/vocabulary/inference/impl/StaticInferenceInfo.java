package ml.kit.cluster.vocabulary.inference.impl;

import ml.kit.cluster.ClusterPool;
import ml.kit.cluster.vocabulary.inference.InferenceInfo;

public abstract class StaticInferenceInfo<T> implements InferenceInfo<T> {
	
	public enum 
	
	private ClusterPool<T> instance = null;
	
	public StaticInferenceInfo()

	public ClusterPool<T> spawnNewClusterPool(Parameter<?> ... parameters){
		if(instance == null) {
			
		}
		return instance;
	}
}
