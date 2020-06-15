package ml.kit.symbol.structure.nonparametric;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import ml.kit.structs.asm.MLObject;
import ml.kit.symbol.Symbol;
import ml.kit.symbol.structure.StructureInfo;
import ml.kit.symbol.structure.SymbolStructure;

public class DPSymbolStructure<T extends MLObject> extends SymbolStructure<T> {

	private Random r = new Random(System.currentTimeMillis());
	protected double gamma = 0.0;
	
	public DPSymbolStructure(StructureInfo<T> behavior, double gamma) {
		super(behavior);
		this.gamma = gamma;
	}

	@Override
	public Symbol<T> excite(T item, double vSize, int capacity) {
		return sample(item, vSize, capacity, 1.0);
	}

	@Override
	public T inhibit(double vSize, int capacity) {
		return sampleAndRemove(vSize, capacity, -1.0);
	}
	
	public T sampleAndRemove(double vSize, int capacity, double weightModifier) {
		int clusterIndex = (int)Math.floor(r.nextDouble() * allClusters.size());
		Symbol<T> symbol = (Symbol<T>)allClusters.toArray()[clusterIndex];
		T ret = symbol.sampleItemFromCluster();
		if(ret != null) {
			symbol.updateWeight(ret, weightModifier);
			if(symbol.clusterSize() < 1) {
				allClusters.remove(symbol);
			}
		}else {
			allClusters.remove(symbol);
		}
		
		return ret;
	}

	public Symbol<T> sample(T item, double vSize, int capacity, double weightModifier) {
		Map<Symbol<T>, Double> likelihoodForSymbol = getSymbolLikelihoods(item, vSize, capacity);
		
		Symbol<T> ret = sampleForCluster(item, vSize, likelihoodForSymbol, gamma);
		if(ret != null) {
			Double likelihood = likelihoodForSymbol.get(ret);
			likelihood = likelihood == null ? 0.0 : likelihood;
			ret.updateWeight(item, weightModifier);
		}
		
		return ret;
	}

	protected Symbol<T> sampleForCluster(T item, double vSize, Map<Symbol<T>, Double> likelihoodForSymbol, double gamma) {
		double pSum = 0.0;
		List<Symbol<T>> clusters = new ArrayList<>();
		clusters.addAll(allClusters);
		double[] p = new double[clusters.size() + 1];
		int index = 0;

		for (Symbol<T> cluster : clusters) {
			Double likelihood = likelihoodForSymbol.get(cluster);
			likelihood = likelihood == null ? 0.0 : likelihood;
			pSum += likelihood;
			p[index] = pSum;
			index++;
		}
		pSum += gamma / (vSize - 1 + gamma);
		p[p.length - 1] = pSum;
		// --------------------------

		// -------------------------- select topic
		Symbol<T> ret = null;
		double clusterSelector = r.nextDouble() * pSum;
		for (int i = 0; i < p.length; i++) {
			if (clusterSelector < p[i]) {
				if(i == p.length - 1) {
					ret = createNewSymbol();
					allClusters.add(ret);
				}else {
					ret = clusters.get(i);
					break;
				}
			}
		}

		return ret;
		// --------------------------
	}
	
	public Map<Symbol<T>, Double> getSymbolLikelihoods(T item, double vSize, int capacity) {
		// ------------------------ likelihood function
		Map<Symbol<T>, Double> likelihoodForSymbol = new HashMap<>();
		for (Symbol<T> cluster : allClusters) {
			double likelihood = cluster.calcAssignmentLikelihood(item, vSize, capacity);
			likelihood = likelihood * (cluster.clusterSize() / (vSize - 1 + gamma));
			likelihoodForSymbol.put(cluster, likelihood);
		}
		
		return likelihoodForSymbol;
	}

}
