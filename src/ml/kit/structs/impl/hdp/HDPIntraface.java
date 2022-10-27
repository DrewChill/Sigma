package ml.kit.structs.impl.hdp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import ml.kit.structs.asm.MLObject;
import ml.kit.structs.group.Intraface;
import archive.ProbabilisticSymbol;
import ml.kit.observer.symbol.Symbol;
import ml.kit.observer.symbol.SymbolGenerator;
import ml.kit.observer.Observer;
import ml.kit.observer.ObserverBasis;

public class HDPIntraface<T extends MLObject> extends Intraface<T> {
	
	//---------------------
	public HDPIntraface(SymbolGenerator<T> symbolGenerator) {
		super(symbolGenerator);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ProbabilisticSymbol<T> fuseSymbol(T item, int populationSize, double totalAssignmentLikelihood,
			Map<Symbol<T>, Double> densityForSymbol, Observer<T> behavior) {
		ObserverBasis<Double> alpha = (ObserverBasis<Double>)behavior.getParameterValue("alpha");
		ObserverBasis<Double> gamma = (ObserverBasis<Double>)behavior.getParameterValue("gamma");
		
		// -------------------------- table find
		double p[];
		List<Symbol<T>> clusters = new ArrayList<>();
		double pSum = 0.0;
		synchronized (getConnections()) {
			p = new double[getConnections().size() + 1];
			int j = 0;
			for (Symbol<T> cluster : getConnections()) {
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

		Symbol<T> sampled = clusters.get(clusterNumber);
		if(sampled == null) {
			return null;
		}
		
		double likelihood = densityForSymbol.get(sampled);
		return new ProbabilisticSymbol<T>(sampled, likelihood);
	}

}
