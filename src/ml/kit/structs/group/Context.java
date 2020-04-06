package ml.kit.structs.group;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import ml.kit.structs.asm.MLObject;
import ml.kit.symbol.SymbolGenerator;

public abstract class Context<T extends MLObject> {
	
	protected SymbolGenerator<T> vocabulary;
	private Collection<Synapse<T>> inputs = new ArrayList<>();

	public Context(SymbolGenerator<T> vocabulary) {
		this.vocabulary = vocabulary;
	}
	
	protected abstract Synapse<T> createGroup(InputStream input);
	
	public Synapse<T> addInputStream(InputStream input){
		Synapse<T> syn = createGroup(input);
		inputs.add(syn);
		return syn;
	}
	
	public int getContextSize() {
		return inputs.size();
	}
	
}
