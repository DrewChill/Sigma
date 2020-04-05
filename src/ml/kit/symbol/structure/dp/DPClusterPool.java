package ml.kit.symbol.structure.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import ml.kit.structs.item.Stimulus;
import ml.kit.symbol.Symbol;
import ml.kit.symbol.indicator.DPIndicatorGenerator;
import ml.kit.symbol.structure.SymbolStructure;

public class DPClusterPool<T> implements SymbolStructure<T>{
	
	Map<String, Symbol<T>> clusterMap = new HashMap<>();
	private DPIndicatorGenerator<T> deepIndicator = new DPIndicatorGenerator<T>();
	private double gamma = 1.5;
	private Random r = new Random();

	@Override
	public Symbol<T> signalSymbolStructure(Stimulus<T> item) {
		return sampleForCluster(item);
	}
	
	private Symbol<T> sampleForCluster(Stimulus<T> item){
		double vSize = (double)item.getSource().vocabularySize();
		double pSum = 0.0;
		List<Symbol<T>> clusterList = new ArrayList<>();
		//------------------------ likelihood
		double[] p = new double[clusterMap.size()+1];
		int index = 0;
		for(Symbol<T> cluster : clusterMap.values()) {
			pSum += cluster.calcAssignmentLikelihood(item);
			p[index] = pSum;
			index++;
			clusterList.add(cluster);
		}
		pSum += gamma / vSize;
		p[p.length - 1] = pSum;
		//--------------------------
		
		//-------------------------- select topic
		Symbol<T> ret = null;
		double clusterSelector = r.nextDouble() * pSum;
		for(int i=0; i<p.length-1; i++) {
			if(clusterSelector < p[i]) {
				ret = clusterList.get(i);
			}
				
		}
		
		return ret != null ? ret : new DPCluster<T>(deepIndicator); 
		//--------------------------
	}

}