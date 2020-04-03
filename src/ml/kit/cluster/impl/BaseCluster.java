package ml.kit.cluster.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import ml.kit.cluster.Symbol;
import ml.kit.cluster.indicator.IndicatorGenerator;
import ml.kit.structs.item.Stimulus;

public class BaseCluster<T extends Serializable> extends Symbol<T>{

	Map<T, Integer> wordCount = new HashMap<>();
	
	public BaseCluster(IndicatorGenerator<T> indicatorGenerator) {
		super(indicatorGenerator);
	}
	
	@Override
	public boolean addOrRejectItem(Stimulus<T> item) {
		if(super.addOrRejectItem(item)) {
			Integer count = wordCount.get(item.getValue());
			if(count == null) {
				count = 0;
			}
			wordCount.put(item.getValue(), ++count);
			return true;
		}else {
			return false;
		}
	}

	@Override
	protected double calcAssignmentStrength() {
		double entropy = 0.0;
		
		double totalWords = (double)items.size();
		for(T word : wordCount.keySet()) {
			double count = (double)wordCount.get(word);
			double p = count/totalWords;
			entropy += p * (Math.log(1.0/p) / Math.log(2));
		}
		return entropy;
	}

	@Override
	public double calcAssignmentLikelihood(Stimulus<T> item) {
		return (wordCount.size() > 0) ? 0.0 : 1.0;
	}

	@Override
	protected boolean shouldAdd(T item) {
		return true;
	}

}
