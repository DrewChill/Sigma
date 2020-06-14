package ml.kit.structs.group;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import ml.kit.structs.asm.MLObject;
import ml.kit.symbol.SymbolGenerator;
import ml.kit.symbol.structure.StructureInfo;

public abstract class Context<T extends MLObject> {
	
	protected SymbolGenerator<T> vocabulary;
	private Collection<Synapse<T>> inputs = new ArrayList<>();

	public Context(StructureInfo<T> contextStructure) {
		this.vocabulary = new SymbolGenerator<T>(contextStructure);
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
	
}
