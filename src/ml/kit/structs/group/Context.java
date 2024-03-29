package ml.kit.structs.group;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import ml.kit.structs.asm.MLObject;
import ml.kit.symbol.Symbol;
import ml.kit.symbol.SymbolGenerator;
import ml.kit.symbol.structure.StructureInfo;

public abstract class Context<T extends MLObject> {
	
	public SymbolGenerator<T> vocabulary;
	private Collection<Synapse<T>> inputs = new ArrayList<>();

	public Context(StructureInfo<T> contextStructure) {
		this.vocabulary = new SymbolGenerator<T>(contextStructure);
		this.vocabulary.setContext(this);
	}
	
	protected abstract Synapse<T> createGroup(InputStream input);
	protected abstract Synapse<T> createGroup();
	
	public Synapse<T> addInputStream(InputStream input){
		Synapse<T> syn = createGroup(input);
		inputs.add(syn);
		return syn;
	}
	
	public Synapse<T> addInputStream(){
		Synapse<T> syn = createGroup();
		inputs.add(syn);
		return syn;
	}
	
	public int getContextSize() {
		return inputs.size();
	}
	
	public Collection<Symbol<T>> digestInformation(int iterations){
		return vocabulary.postProcess(iterations);
	}
	
	public Set<Symbol<T>> processQueue() {
		return vocabulary.generate();
	}
	
}
