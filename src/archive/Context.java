package archive;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import archive.asm.Observable;
import ml.kit.observer.symbol.NullGenerator;
import ml.kit.observer.AbstractObserver;

public abstract class Context<T extends Observable> {
	
	public NullGenerator<T> vocabulary;
	private Collection<AbstractEmitter<T>> inputs = new ArrayList<>();

	public Context(AbstractObserver<T> contextStructure) {
		this.vocabulary = new NullGenerator<T>(contextStructure);
		this.vocabulary.setContext(this);
	}
	
	protected abstract AbstractEmitter<T> createGroup(InputStream input);
	protected abstract AbstractEmitter<T> createGroup();
	
	public AbstractEmitter<T> addInputStream(InputStream input){
		AbstractEmitter<T> syn = createGroup(input);
		inputs.add(syn);
		return syn;
	}
	
	public AbstractEmitter<T> addInputStream(){
		AbstractEmitter<T> syn = createGroup();
		inputs.add(syn);
		return syn;
	}
	
	public int getContextSize() {
		return inputs.size();
	}
	
	public Collection<StochasticSymbol<T>> digestInformation(int iterations){
		return vocabulary.postProcess(iterations);
	}
	
	public Set<StochasticSymbol<T>> processQueue() {
		return vocabulary.generate();
	}
	
}
