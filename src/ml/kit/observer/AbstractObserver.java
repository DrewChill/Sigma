package ml.kit.observer;

import java.util.*;

import ml.kit.function.SymbolShape;
import archive.StochasticSymbol;
import ml.kit.observer.symbol.NullGenerator;
import archive.asm.Observable;
import archive.AbstractEmitter;
import archive.ObservationHistory;
import archive.RelationHistory;
import ml.kit.observer.symbol.SymbolFilter;
import ml.kit.observer.symbol.relation.SymbolRelation;
import ml.kit.observer.symbol.relation.nonparametric.DPSymbol;
import ml.kit.observer.symbol.relation.nonparametric.HDPSymbol;

public class AbstractObserver<T extends Observable> {

	// ---------------

	public SymbolFilter filter;
	public ObserverLocality locality;

	public SymbolShape<T> localShape;
	public SymbolRelation<T> globalShape;

	public NullGenerator<T> vocabulary;
	private Collection<AbstractEmitter<T>> inputs = new ArrayList<>();

	public Map<String,ObserverBasis<?>> parameters = new HashMap<>();

	public RelationHistory<T,StochasticSymbol<T>> relationHistory = new RelationHistory<>();

	public AbstractObserver(SymbolRelation<T> globalShape, SymbolFilter filter, ObserverLocality locality,
			SymbolShape<T> localShape, ObserverBasis<?>... parameters) {
		for (ObserverBasis<?> parameter : parameters) {
			this.parameters.put(parameter.getName(), parameter);
		}
		this.filter = filter;
		this.locality = locality;
		this.localShape = localShape;
		this.globalShape = globalShape;
	}

	public int getContextSize() {
		return inputs.size();
	}

	public Set<StochasticSymbol<T>> processQueue() {
		return vocabulary.generate();
	}

	public Collection<StochasticSymbol<T>> digestInformation(int iterations){
		return vocabulary.postProcess(iterations);
	}


	//-----------------------------------

	public SymbolRelation<T> getStructure() {
		return globalShape;
	}

	//-----------------------------------

	public void addNext(AbstractObserver<T> next) {

	}

	// TODO: throw exception for null
	public ObserverBasis<?> getParameterValue(String name) {
		return parameters.get(name);
	}

	@SuppressWarnings("unchecked")
	public StochasticSymbol<T> createNewSymbol() {
		StochasticSymbol<T> ret = null;
		switch (globalShape.globalShape()) {
		case DP:
			ret = new DPSymbol<T>(relationHistory.spawnSymbolicEntropy(), localShape);
			break;
		case HDP:
			ret = new HDPSymbol<T>(relationHistory.spawnSymbolicEntropy(), localShape);
			break;
		case CUSTOM:
		case NP_PAM:
		case nDP:
		case nHDP:
		default:
			ret = null;
		}
		
		localShape = localShape.initNext();
		
		return ret;
	}

	public ObservationHistory<StochasticSymbol<T>> createUpstreamConnection(AbstractEmitter<T> intraface) {
		return relationHistory.spawnSynapticEntropy(intraface);
	}

}
