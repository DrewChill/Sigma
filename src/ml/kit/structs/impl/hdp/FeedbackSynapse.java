package ml.kit.structs.impl.hdp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import ml.kit.structs.asm.MLObject;
import ml.kit.structs.group.Synapse;
import ml.kit.symbol.StochasticSymbol;
import ml.kit.symbol.Symbol;
import ml.kit.symbol.SymbolGenerator;
import ml.kit.symbol.structure.StructureInfo;
import ml.kit.symbol.structure.StructureParameter;
import ml.kit.symbol.structure.StructureInfo.InferenceFlow;
import ml.kit.symbol.structure.StructureInfo.InferenceLocality;
import ml.kit.symbol.structure.StructureInfo.InferenceStructure;

public class FeedbackSynapse<T extends MLObject> extends Synapse<T> {

	private static StructureInfo<T> defaultLearningInfo;

	static {
		StructureParameter<Double> alpha = new StructureParameter<Double>(1.5, "alpha");
		StructureParameter<Double> gamma = new StructureParameter<Double>(1.5, "gamma");
		defaultLearningInfo = new StructureInfo<T>(InferenceStructure.HDP, InferenceFlow.LINEAR, InferenceLocality.LOCAL, alpha,
				gamma);
	}
	
	//---------------------
	
	private StructureInfo localLearningInfo;

	public FeedbackSynapse(SymbolGenerator<T> vocabulary) {
		super(vocabulary);
		localLearningInfo = defaultLearningInfo; //TODO: make copy
	}

	@SuppressWarnings("unchecked")
	@Override
	public StochasticSymbol<T> generateSymbol(T item, int populationSize, double totalAssignmentLikelihood,
			Map<Symbol<T>, Double> likelihoodForSymbol) {
		StructureParameter<Double> alpha = (StructureParameter<Double>)localLearningInfo.getParameterValue("alpha");
		StructureParameter<Double> gamma = (StructureParameter<Double>)localLearningInfo.getParameterValue("gamma");
		
		// -------------------------- table find
		double p[];
		List<Symbol<T>> clusters = new ArrayList<>();
		double pSum = 0.0;
		synchronized (getConnections()) {
			p = new double[getConnections().size() + 1];
			int j = 0;
			for (Symbol<T> cluster : getConnections()) {
				pSum += ((double) synapticEntropy.observationCount(cluster) * likelihoodForSymbol.get(cluster));
				p[j] = pSum;
				clusters.add(cluster);
				j++;
			}
		}
		// ----------------------------

		// ---------------------------- get table #
		pSum += (alpha.getValue() * totalAssignmentLikelihood) / (((double) populationSize) + gamma.getValue());
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
		
		double likelihood = likelihoodForSymbol.get(sampled);
		return new StochasticSymbol<T>(sampled, likelihood);
	}

}
