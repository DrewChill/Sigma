package ml.kit.symbol.structure.hdp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import ml.kit.structs.asm.MLObject;
import ml.kit.structs.group.Synapse;
import ml.kit.symbol.StochasticSymbol;
import ml.kit.symbol.Symbol;
import ml.kit.symbol.entropy.StructureEntropy;
import ml.kit.symbol.generator.inference.InferenceInfo;
import ml.kit.symbol.structure.SymbolStructure;

public class HDPSymbolStructure<T extends MLObject> extends SymbolStructure<T>{

	Map<byte[], Symbol<T>> clusterMap = new HashMap<>();
	private StructureEntropy<T> structureEntropy = new StructureEntropy<>();
	private double gamma = 1.5;
	private double beta = 0.5;
	private Random r = new Random();
	private int id;
	
	public HDPSymbolStructure(InferenceInfo behavior) {
		super(behavior);
		//get gamma/beta
	}
	
	@Override
	public Symbol<T> excite(T item, double vSize, int capacity) {
		return sample(item, vSize, capacity, 1.0);
	}

	@Override
	public Symbol<T> inhibit(T item, double vSize, int capacity) {
		return sample(item, vSize, capacity, 1.0);
	}
	
	public Symbol<T> sample(T item, double vSize, int capacity, double weightModifier) {
		double totalAssignmentLikelihood = 0.0;
		
		//------------------------ likelihood function
		Map<Symbol<T>, Double> likelihoodForSymbol = new HashMap<>();
		for(Symbol<T> cluster : clusterMap.values()) {
			double likelihood = cluster.calcAssignmentLikelihood(item, vSize, capacity);
			likelihoodForSymbol.put(cluster, likelihood);
			totalAssignmentLikelihood += likelihood;
		}
		totalAssignmentLikelihood += gamma * vSize;
		//--------------------------
		
		Synapse<T> synapse = item.getSynapseForStructureId(id);
		StochasticSymbol<T> sampledSymbol = synapse.generateSymbol(item, capacity, totalAssignmentLikelihood);
		Symbol<T> ret = sampledSymbol.symbol;
		if(ret == null) {
			ret = sampleForCluster(item, vSize, likelihoodForSymbol);
		}
		
		Double likelihood = likelihoodForSymbol.get(ret);
		likelihood = likelihood == null ? 0.0 : likelihood;
		ret.updateWeight(item, likelihood * weightModifier);
		return ret;
	}
	
	private Symbol<T> sampleForCluster(T item, double vSize, Map<Symbol<T>, Double> likelihoodForSymbol){
		double pSum = 0.0;
		List<Symbol<T>> clusters = new ArrayList<>();
		clusters.addAll(clusterMap.values());
		double[] p = new double[clusterMap.size()+1];
		int index = 0;
		
		for(Symbol<T> cluster : clusters) {
			Double likelihood = likelihoodForSymbol.get(cluster);
			likelihood = likelihood == null ? 0.0 : likelihood;
			pSum += likelihood;
			p[index] = pSum;
			index++;
		}
		pSum += gamma / vSize;
		p[p.length - 1] = pSum;
		//--------------------------
		
		//-------------------------- select topic
		Symbol<T> ret = null;
		double clusterSelector = r.nextDouble() * pSum;
		for(int i=0; i<p.length-1; i++) {
			if(clusterSelector < p[i]) {
				ret = clusters.get(i);
			}
				
		}
		
		return ret != null ? ret : new HDPSymbol<T>(structureEntropy.spawnEntropy(), beta); 
		//--------------------------
	}

}
