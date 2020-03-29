package ml.kit.cluster.impl.dp;

import ml.kit.cluster.Cluster;
import ml.kit.cluster.indicator.IndicatorGenerator;
import ml.kit.structs.item.Item;

public class DPCluster<T> extends Cluster<T>{

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
	public double calcAssignmentLikelihood(Item<T> item) {
		double vSize = (double)item.getSource().vocabularySize();
		double vb = vSize * beta;
		
		double fk =  (((double)occurences(item.getValue())) + beta) / 
		             (((double)clusterSize()) + vb);
		return fk;
	}

}
