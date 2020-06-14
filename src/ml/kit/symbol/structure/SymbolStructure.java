package ml.kit.symbol.structure;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Set;

import ml.kit.structs.asm.MLObject;
import ml.kit.structs.group.Synapse;
import ml.kit.symbol.Symbol;

public abstract class SymbolStructure<T extends MLObject> {
	
	protected StructureInfo<T> behavior;
	private Synapse<Symbol<T>> downstream = null;
	private volatile int size = 0;
	
	public SymbolStructure(StructureInfo<T> behavior) {
		this.behavior = behavior;
	}
	
	public Symbol<T> createNewSymbol(){
		return behavior.createNewSymbol();
	}
	
	public Symbol<T> stimulate(T item, double vSize, int capacity){
		size++;
		return excite(item, vSize, capacity);
	}
	
	public Symbol<T> decay(T item, double vSize, int capacity){
		size--;
		return inhibit(item, vSize, capacity);
	}
	
	protected abstract Symbol<T> excite(T item, double vSize, int capacity);
	
	protected abstract Symbol<T> inhibit(T item, double vSize, int capacity);
	
	public ByteBuffer generateSymbolStream(double weight) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			Set<Synapse<T>> synapses = behavior.structureEntropy.getSynapses();
			
			for(Synapse<T> synapse : synapses) {
				bos.write(synapse.fire((double)size * weight, weight));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ByteBuffer.wrap(bos.toByteArray());
	}
	
	public void propagate() {
		propagate(1.0);
	}
	
	public void propagate(double weight) {
		if(downstream == null) {
			downstream = behavior.getNextContext().addInputStream();
		}
		
		if(downstream != null) {
			downstream.addData(generateSymbolStream(weight));
		}
	}

}
