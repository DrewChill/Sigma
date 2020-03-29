package ml.kit.structs.group;

import ml.kit.cluster.Cluster;

public interface Generator<T> {
	
	public Context<T> newContext(Cluster<T> parent);

}
