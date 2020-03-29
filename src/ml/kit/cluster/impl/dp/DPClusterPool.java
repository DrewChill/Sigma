package ml.kit.cluster.impl.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import ml.kit.cluster.Cluster;
import ml.kit.cluster.ClusterPool;
import ml.kit.cluster.indicator.DPIndicatorGenerator;
import ml.kit.structs.item.Item;

public class DPClusterPool<T> implements ClusterPool<T>{
	
	Map<String, Cluster<T>> clusterMap = new HashMap<>();
	private DPIndicatorGenerator<T> deepIndicator = new DPIndicatorGenerator<T>();
	private double gamma = 1.5;
	private Random r = new Random();

	@Override
	public Cluster<T> addItemToClusterPool(Item<T> item) {
		return sampleForCluster(item);
	}
	
	private Cluster<T> sampleForCluster(Item<T> item){
		double vSize = (double)item.getSource().vocabularySize();
		double pSum = 0.0;
		List<Cluster<T>> clusterList = new ArrayList<>();
		//------------------------ likelihood
		double[] p = new double[clusterMap.size()+1];
		int index = 0;
		for(Cluster<T> cluster : clusterMap.values()) {
			pSum += cluster.calcAssignmentLikelihood(item);
			p[index] = pSum;
			index++;
			clusterList.add(cluster);
		}
		pSum += gamma / vSize;
		p[p.length - 1] = pSum;
		//--------------------------
		
		//-------------------------- select topic
		Cluster<T> ret = null;
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
