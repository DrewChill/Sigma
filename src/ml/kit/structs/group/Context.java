package ml.kit.structs.group;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ml.kit.symbol.Symbol;
import ml.kit.symbol.generator.SymbolGenerator;

public abstract class Context<T> {
	
	protected SymbolGenerator<T> vocabulary;

	public Context(SymbolGenerator<T> vocabulary) {
		this.vocabulary = vocabulary;
	}
	
	public abstract Synapse<T> createGroup(InputStream input);
	
	public Collection<Context<T>> chain(Generator<T> generator){
		List<Context<T>> generated = new ArrayList<>();
		for(Symbol<T> cluster : vocabulary.allClusters()) {
			generated.add(generator.newContext(cluster));
		}
		return generated;
	}
	
	public Context<T> fit(Context<T> otherContext){
		for(Symbol<T> cluster : vocabulary.allClusters()) {
			otherContext.createGroup(cluster.mergedStream());
		}
		return otherContext;
	}
	
}