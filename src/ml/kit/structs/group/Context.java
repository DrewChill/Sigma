package ml.kit.structs.group;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ml.kit.cluster.Cluster;
import ml.kit.cluster.vocabulary.Vocabulary;

public abstract class Context<T> {
	
	protected Vocabulary<T> vocabulary;

	public Context(Vocabulary<T> vocabulary) {
		this.vocabulary = vocabulary;
	}
	
	public abstract Group<T> createGroup(InputStream input);
	
	public Collection<Context<T>> chain(Generator<T> generator){
		List<Context<T>> generated = new ArrayList<>();
		for(Cluster<T> cluster : vocabulary.allClusters()) {
			generated.add(generator.newContext(cluster));
		}
		return generated;
	}
	
	public Context<T> fit(Context<T> otherContext){
		for(Cluster<T> cluster : vocabulary.allClusters()) {
			otherContext.createGroup(cluster.mergedStream());
		}
		return otherContext;
	}
	
}
