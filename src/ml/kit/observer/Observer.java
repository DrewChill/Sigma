package ml.kit.observer;

import java.util.HashMap;
import java.util.Map;

import ml.kit.function.SymbolFunction;
import ml.kit.observer.symbol.Symbol;
import ml.kit.structs.asm.MLObject;
import ml.kit.structs.group.Context;
import ml.kit.structs.group.Intraface;
import ml.kit.observer.history.ObservationHistory;
import ml.kit.observer.history.RelationHistory;
import ml.kit.observer.symbol.SymbolFilter;
import ml.kit.observer.symbol.relation.SymbolRelation;
import ml.kit.observer.symbol.relation.nonparametric.DPSymbol;
import ml.kit.observer.symbol.relation.nonparametric.HDPSymbol;

public class Observer<T extends MLObject> {

	// ---------------

	public SymbolFilter filter;
	public ObserverLocality locality;

	public SymbolFunction<T> localShape;
	public SymbolRelation<T> globalShape;

	public Map<String,ObserverBasis<?>> parameters = new HashMap<>();

	public RelationHistory<T, Symbol<T>> relationHistory = new RelationHistory<>();

	@SuppressWarnings("unchecked")
	public Observer(SymbolRelation<T> globalShape, SymbolFilter filter, ObserverLocality locality,
			SymbolFunction<T> localShape, ObserverBasis<?>... parameters) {
		for (ObserverBasis<?> parameter : parameters) {
			this.parameters.put(parameter.getName(), parameter);
		}
		this.filter = filter;
		this.locality = locality;
		this.localShape = localShape;
		this.globalShape = globalShape;
	}

	public SymbolRelation<T> getStructure() {
		return globalShape;
	}










	//-----------------------------------

	public void addNext(Observer<T> next) {

	}

	// TODO: throw exception for null
	public ObserverBasis<?> getParameterValue(String name) {
		return parameters.get(name);
	}

	@SuppressWarnings("unchecked")
	public Symbol<T> createNewSymbol() {
		Symbol<T> ret = null;
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

	public ObservationHistory<Symbol<T>> createUpstreamConnection(Intraface<T> intraface) {
		return relationHistory.spawnSynapticEntropy(intraface);
	}

}
