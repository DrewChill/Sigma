package ml.kit.symbol.structure.hdp;

import java.util.HashMap;
import java.util.Map;

import ml.kit.structs.asm.MLObject;
import ml.kit.structs.group.Synapse;
import ml.kit.symbol.StochasticSymbol;
import ml.kit.symbol.Symbol;
import ml.kit.symbol.structure.StructureInfo;
import ml.kit.symbol.structure.nonparametric.DPSymbolStructure;

public class HDPSymbolStructure<T extends MLObject> extends DPSymbolStructure<T>{

	Map<byte[], Symbol<T>> clusterMap = new HashMap<>();
	private int id;
	
	public HDPSymbolStructure(StructureInfo<T> behavior, double gamma) {
		super(behavior, gamma);
	}
	
	@SuppressWarnings("unchecked")
	public Symbol<T> sample(T item, double vSize, int capacity, double weightModifier) {		
		//------------------------ likelihood function
		Map<Symbol<T>, Double> likelihoodForSymbol = getSymbolLikelihoods(item, vSize, capacity);
		double totalAssignmentLikelihood = totalAssignmentLikelihood(likelihoodForSymbol, gamma, vSize);
		//--------------------------
		
		Synapse<T> synapse = (Synapse<T>) item.getSynapseForStructureId(id);
		StochasticSymbol<T> sampledSymbol = synapse.generateSymbol(item, capacity, totalAssignmentLikelihood, likelihoodForSymbol);
		Symbol<T> ret = sampledSymbol.symbol;
		if(ret == null) {
			ret = sampleForCluster(item, vSize, likelihoodForSymbol, gamma);
		}
		
		Double likelihood = likelihoodForSymbol.get(ret);
		likelihood = likelihood == null ? 0.0 : likelihood;
		ret.updateWeight(item, likelihood * weightModifier);
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
