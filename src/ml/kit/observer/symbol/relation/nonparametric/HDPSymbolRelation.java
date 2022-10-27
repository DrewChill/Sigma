package ml.kit.observer.symbol.relation.nonparametric;

import java.util.HashMap;
import java.util.Map;

import ml.kit.structs.asm.MLObject;
import ml.kit.structs.group.Intraface;
import archive.ProbabilisticSymbol;
import ml.kit.observer.symbol.Symbol;
import ml.kit.observer.Observer;

public class HDPSymbolRelation<T extends MLObject> extends DPSymbolRelation<T> {

	Map<byte[], Symbol<T>> clusterMap = new HashMap<>();
	private int id;
	
	public HDPSymbolRelation(Observer<T> behavior, double gamma) {
		super(behavior, gamma);
	}
	
	@SuppressWarnings("unchecked")
	public Symbol<T> sample(T item, double vSize, int capacity, double weightModifier) {		
		//------------------------ likelihood function
		Map<Symbol<T>, Double> likelihoodForSymbol = getSymbolLikelihoods(item, vSize, capacity);
		double totalAssignmentLikelihood = totalAssignmentLikelihood(likelihoodForSymbol, gamma, vSize);
		//--------------------------
		
		Intraface<T> intraface = (Intraface<T>) item.getSynapseForStructureId(id);
		ProbabilisticSymbol<T> sampledSymbol = intraface.fuseSymbol(item, capacity, totalAssignmentLikelihood, likelihoodForSymbol, behavior);
		Symbol<T> ret = sampledSymbol.symbol;
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
	
	private double totalAssignmentLikelihood(Map<Symbol<T>, Double> likelihoodForSymbol, double gamma, double vSize) {
		double totalAssignmentLikelihood = 0.0;
		for(Double likelihood : likelihoodForSymbol.values()) {
			totalAssignmentLikelihood += likelihood;
		}
		totalAssignmentLikelihood += gamma * vSize;
		
		return totalAssignmentLikelihood;
	}

}
