package ml.observer.symbol;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import archive.StochasticSymbol;
import ml.observer.AbstractObserver;
import ml.observer.Observer;
import archive.asm.Observable;
import archive.Context;
import archive.AbstractEmitter;
import archive.ObservationHistory;
import ml.foundation.primitive.vector.VectorVariable;

public class NullGenerator<T> extends Observer<T,VectorVariable<T>> {

	private List<StochasticSymbol<T>> allClusters = new ArrayList<>();
	private NullGenerator<T> inferredVocabulary = null;
	private Set<T> processQueue = new HashSet<>();
	private AbstractObserver<T> model;
	private volatile int totalObservationCount = 0;
	private Context<T> currentContext = null;
	public volatile int id = 0;
	public volatile static int num = 0;

	public NullGenerator(AbstractObserver<T> model) {
		this.id = num++;
		this.model = model;
	}
	
	public ObservationHistory<StochasticSymbol<T>> registerSynapse(AbstractEmitter<T> intraface){
		return model.createUpstreamConnection(intraface);
	}

	public void setContext(Context<T> context) {
		currentContext = context;
	}

	public void queueMLObject(T item) {
		synchronized (processQueue) {
			totalObservationCount++;
			processQueue.add(item);
		}
	}

	public Set<StochasticSymbol<T>> generate() {
		System.out.println("processing...");
		Set<StochasticSymbol<T>> symbols = new HashSet<>();
		Set<T> queueCopy = new HashSet<T>();
		synchronized (processQueue) {
			queueCopy.addAll(processQueue);
			processQueue.clear();
		}
		
		for (T item : queueCopy) {
			StochasticSymbol<T> symbol = model.getStructure().stimulate(item, totalObservationCount, currentContext.getContextSize());
			symbols.add(symbol);
			AbstractEmitter<? extends Observable> contributor = item.getSynapseForStructureId(id);
			contributor.reuptake(symbol);
			symbol.addContributor(contributor);

			synchronized (allClusters) {
				if (!allClusters.contains(symbol))
					allClusters.add(symbol);
			}
		}
		//System.out.println("done...");
		return symbols;
	}
	
	public Collection<StochasticSymbol<T>> postProcess(int iterations) {
		for(int i=0; i<iterations; i++) {
			T removed = model.getStructure().decay(totalObservationCount, currentContext.getContextSize());
			if(removed != null) {
				StochasticSymbol<T> symbol = model.getStructure().stimulate(removed, totalObservationCount - 1, currentContext.getContextSize());
				synchronized (allClusters) {
					if (!allClusters.contains(symbol))
						allClusters.add(symbol);
				}
			}
		}
		return model.getStructure().allClusters;
	}
	
	public StochasticSymbol<T> sample(T data){
		return model.getStructure().stimulate(data, totalObservationCount, currentContext.getContextSize());
	}

	public int totalItemsContributed() {
		int count = 0;
		for (StochasticSymbol<T> cluster : allClusters) {
			count += cluster.clusterSize();
		}
		return count;
	}

	public Collection<StochasticSymbol<T>> allClusters() {
		synchronized (allClusters) {
			return allClusters;
		}
	}

	public StochasticSymbol<T> decodeBytes(byte[] encoded) {
		return null;
	}

	public NullGenerator<T> getNestedVocabulary() {
		return inferredVocabulary;
	}

}
