package ml.kit.cluster.vocabulary.inference;

import ml.kit.cluster.SymbolStructure;
import ml.kit.cluster.vocabulary.inference.impl.Parameter;

public interface InferenceInfo<T> {
	
	public SymbolStructure<T> spawnNewClusterPool(Parameter<?> ... parameters);
	
	public void addNext(InferenceInfo<T> next);
	
	public InferenceInfo<T> getNext();

}
