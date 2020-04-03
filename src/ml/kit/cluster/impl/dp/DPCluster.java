package ml.kit.cluster.impl.dp;

import ml.kit.cluster.Symbol;
import ml.kit.cluster.indicator.IndicatorGenerator;
import ml.kit.structs.item.Stimulus;

public class DPCluster<T> extends Symbol<T>{

	private double beta = 0.5;

	public DPCluster(IndicatorGenerator<T> indicatorGenerator) {
		super(indicatorGenerator);
	}

	@Override
	protected boolean shouldAdd(T item) {
		return false;
	}

	@Override
	protected double calcAssignmentStrength() {
		return 0;
	}

	@Override
	public double calcAssignmentLikelihood(Stimulus<T> item) {
		double vSize = (double)item.getSource().vocabularySize();
		double vb = vSize * beta;
		
		double fk =  (((double)occurences(item.getValue())) + beta) / 
		             (((double)clusterSize()) + vb);
		return fk;
	}

}
