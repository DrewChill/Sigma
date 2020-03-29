package ml.kit.cluster.impl.hdp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import ml.kit.cluster.Cluster;
import ml.kit.cluster.ClusterPool;
import ml.kit.cluster.indicator.HDPIndicatorGenerator;
import ml.kit.structs.item.Item;

public class HDPClusterPool<T> implements ClusterPool<T>{

	Map<String, Cluster<T>> clusterMap = new HashMap<>();
	private HDPIndicatorGenerator<T> deepIndicator = new HDPIndicatorGenerator<T>();
	private double gamma = 1.5;
	private Random r = new Random();
	
	@Override
	public Cluster<T> addItemToClusterPool(Item<T> item) {
		double vSize = (double)item.getSource().vocabularySize();
		double fNew = gamma * vSize;
		
		//------------------------ likelihood function
		for(Cluster<T> cluster : clusterMap.values()) {
			fNew += cluster.calcAssignmentLikelihood(item);
		}
		//--------------------------
		
		Cluster<T> ret = item.getSource().sampleGroupForCluster(item, totalNumOfContributors(), fNew);
		if(ret == null) {
			ret = sampleForCluster(item);
		}
		
		ret.addOrRejectItem(item);
		return ret;
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
		
		return ret != null ? ret : new HDPCluster<T>(deepIndicator); 
		//--------------------------
	}
	
	private int totalNumOfContributors() {
		int count = 0;
		for(Cluster<T> cluster : clusterMap.values()) {
			count += cluster.numOfContributors();
		}
		return count;
	}

}
