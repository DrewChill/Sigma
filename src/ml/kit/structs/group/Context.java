package ml.kit.structs.group;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import ml.kit.structs.asm.MLObject;
import ml.kit.observer.symbol.Symbol;
import ml.kit.observer.symbol.SymbolGenerator;
import ml.kit.observer.Observer;

public abstract class Context<T extends MLObject> {
	
	public SymbolGenerator<T> vocabulary;
	private Collection<Intraface<T>> inputs = new ArrayList<>();

	public Context(Observer<T> contextStructure) {
		this.vocabulary = new SymbolGenerator<T>(contextStructure);
		this.vocabulary.setContext(this);
	}
	
	protected abstract Intraface<T> createGroup(InputStream input);
	protected abstract Intraface<T> createGroup();
	
	public Intraface<T> addInputStream(InputStream input){
		Intraface<T> syn = createGroup(input);
		inputs.add(syn);
		return syn;
	}
	
	public Intraface<T> addInputStream(){
		Intraface<T> syn = createGroup();
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
