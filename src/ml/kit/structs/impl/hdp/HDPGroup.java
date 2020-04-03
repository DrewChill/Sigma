package ml.kit.structs.impl.hdp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ml.kit.cluster.Symbol;
import ml.kit.cluster.vocabulary.Vocabulary;
import ml.kit.structs.group.Synapse;
import ml.kit.structs.item.Stimulus;

public class HDPGroup<T> extends Synapse<T>{
	
	private double gamma = 1.5;
	private double alpha = 1.5;

	public HDPGroup(Vocabulary<T> vocabulary) {
		super(vocabulary);
	}

	@Override
	public Symbol<T> sampleGroupForCluster(Stimulus<T> item, int populationSize, double totalAssignmentLikelihood) {
		//-------------------------- table find
		double p[];
		List<Symbol<T>> clusters = new ArrayList<>();
		double pSum = 0.0;
		synchronized(getContributions()) {
			p = new double[getContributions().size() + 1];
			int j = 0;
			for(Symbol<T> cluster : getContributions()){
				pSum += ((double)cluster.contributionsFromSource(this)) 
						* cluster.calcAssignmentLikelihood(item);
				p[j] = pSum;
				clusters.add(cluster);
				j++;
			}
		}
		//----------------------------
		
		//---------------------------- get table #
		pSum += (alpha * totalAssignmentLikelihood) / (((double)populationSize) + gamma);
		p[p.length-1] = pSum;
		Random r = new Random();
		double u = r.nextDouble() * pSum;
		int clusterNumber = 0;
		for(clusterNumber=0; clusterNumber<p.length; clusterNumber++) {
			if(u < p[clusterNumber])
				break;
		}
		//---------------------------
		
		return (clusterNumber > clusters.size()) ? null : clusters.get(clusterNumber);
	}

}
