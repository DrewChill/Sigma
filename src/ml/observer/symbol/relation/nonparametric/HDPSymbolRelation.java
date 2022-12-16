package ml.observer.symbol.relation.nonparametric;

import java.util.HashMap;
import java.util.Map;

import archive.asm.Observable;
import archive.AbstractEmitter;
import archive.ProbabilisticSymbol;
import archive.StochasticSymbol;
import ml.observer.AbstractObserver;

public class HDPSymbolRelation<T extends Observable> extends DPSymbolRelation<T> {

	Map<byte[],StochasticSymbol<T>> clusterMap = new HashMap<>();
	private int id;
	
	public HDPSymbolRelation(AbstractObserver<T> behavior, double gamma) {
		super(behavior, gamma);
	}
	
	@SuppressWarnings("unchecked")
	public StochasticSymbol<T> sample(T item, double vSize, int capacity, double weightModifier) {
		//------------------------ likelihood function
		Map<StochasticSymbol<T>, Double> likelihoodForSymbol = getSymbolLikelihoods(item, vSize, capacity);
		double totalAssignmentLikelihood = totalAssignmentLikelihood(likelihoodForSymbol, gamma, vSize);
		//--------------------------
		
		AbstractEmitter<T> intraface = (AbstractEmitter<T>) item.getSynapseForStructureId(id);
		ProbabilisticSymbol<T> sampledSymbol = intraface.fuseSymbol(item, capacity, totalAssignmentLikelihood, likelihoodForSymbol, behavior);
		StochasticSymbol<T> ret = sampledSymbol.symbol;
		if(ret == null) {
			ret = sampleForCluster(item, vSize, likelihoodForSymbol, gamma);
		}
		
		if(ret != null) {
			Double likelihood = likelihoodForSymbol.get(ret);
			likelihood = likelihood == null ? 0.0 : likelihood;
			ret.updateWeight(item, likelihood * weightModifier);
		}
		
		return ret;
	}
	
	private double totalAssignmentLikelihood(Map<StochasticSymbol<T>, Double> likelihoodForSymbol, double gamma, double vSize) {
		double totalAssignmentLikelihood = 0.0;
		for(Double likelihood : likelihoodForSymbol.values()) {
			totalAssignmentLikelihood += likelihood;
		}
		totalAssignmentLikelihood += gamma * vSize;
		
		return totalAssignmentLikelihood;
	}

}
