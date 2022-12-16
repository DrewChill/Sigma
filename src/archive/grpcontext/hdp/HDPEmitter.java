package archive.grpcontext.hdp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import archive.asm.Observable;
import archive.AbstractEmitter;
import archive.ProbabilisticSymbol;
import archive.StochasticSymbol;
import ml.observer.symbol.NullGenerator;
import ml.observer.AbstractObserver;
import ml.observer.ObserverBasis;

public class HDPEmitter<T extends Observable> extends AbstractEmitter<T> {
	
	//---------------------
	public HDPEmitter(NullGenerator<T> symbolGenerator) {
		super(symbolGenerator);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ProbabilisticSymbol<T> fuseSymbol(T item, int populationSize, double totalAssignmentLikelihood,
			Map<StochasticSymbol<T>, Double> densityForSymbol, AbstractObserver<T> behavior) {
		ObserverBasis<Double> alpha = (ObserverBasis<Double>)behavior.getParameterValue("alpha");
		ObserverBasis<Double> gamma = (ObserverBasis<Double>)behavior.getParameterValue("gamma");
		
		// -------------------------- table find
		double p[];
		List<StochasticSymbol<T>> clusters = new ArrayList<>();
		double pSum = 0.0;
		synchronized (getConnections()) {
			p = new double[getConnections().size() + 1];
			int j = 0;
			for (StochasticSymbol<T> cluster : getConnections()) {
				pSum += ((double) synapticEntropy.observationCount(cluster) * densityForSymbol.get(cluster));
				p[j] = pSum;
				clusters.add(cluster);
				j++;
			}
		}
		// ----------------------------

		// ---------------------------- get table #
		double pNew = totalAssignmentLikelihood + (gamma.getValue()/((double)populationSize)+gamma.getValue());
		pSum += alpha.getValue() * pNew;
		p[p.length - 1] = pSum;
		Random r = new Random();
		double u = r.nextDouble() * pSum;
		int clusterNumber = 0;
		for (clusterNumber = 0; clusterNumber < p.length; clusterNumber++) {
			if (u < p[clusterNumber])
				break;
		}
		// ---------------------------

		StochasticSymbol<T> sampled = clusters.get(clusterNumber);
		if(sampled == null) {
			return null;
		}
		
		double likelihood = densityForSymbol.get(sampled);
		return new ProbabilisticSymbol<T>(sampled, likelihood);
	}

}
