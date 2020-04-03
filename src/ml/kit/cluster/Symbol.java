package ml.kit.cluster;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import ml.kit.cluster.indicator.IndicatorGenerator;
import ml.kit.cluster.vocabulary.Vocabulary;
import ml.kit.structs.group.Synapse;
import ml.kit.structs.item.Stimulus;

public abstract class Symbol<T> {
	
	protected List<Stimulus<T>> items;	
	IndicatorGenerator<T> indicatorGenerator;
	
	byte[] clusterIndicator = null;
	double clusterStrength = 0.0;
	
	private Random r = new Random();
	
	public Symbol(IndicatorGenerator<T> indicatorGenerator) {
		this.indicatorGenerator = indicatorGenerator;
		items = new ArrayList<>();
		sourceContributions = new HashMap<>();
	}
	
	public abstract Stimulus<T> activate();
	
	public boolean addOrRejectItem(Stimulus<T> item) {
		if(shouldAdd(item.getValue())) {
			synchronized(items) {
				items.add(item);
				Integer count = sourceContributions.get(item.getSource());
				if(count == null || count == 0) {
					count = 0;
					item.getSource().signalContribution(this);
				}
				sourceContributions.put(item.getSource(), ++count);
				clusterIndicator = indicatorGenerator.getLabelForCluster(this);
			}
			return true;
		}else {
			return false;
		}
	}
	
	protected abstract boolean shouldAdd(T item);
	
	protected abstract double calcAssignmentStrength();
	
	public abstract double calcAssignmentLikelihood(Stimulus<T> item);
	
	public byte[] getIndicator() { return clusterIndicator; };
	
	public void removeElement(Stimulus<T> item) {
		synchronized(items) {
			if(items.remove(item)) {
				Integer count = sourceContributions.get(item.getSource());
				sourceContributions.put(item.getSource(), --count);
				if(count == 0) {
					item.getSource().nullifyContribution(this);
				}
				clusterIndicator = indicatorGenerator.getLabelForCluster(this);
			}
		}
	}
	
	public int clusterSize() {
		int count = 0;
		synchronized(items) {
			count = items.size();
		}
		return count;
	}
	
	public Collection<Stimulus<T>> itemList(){
		return items;
	}
	
	public int occurences(T value) {
		int count = 0;
		for(Stimulus<T> item : items) {
			if(item.getValue().equals(value))
				count++;
		}
		return count;
	}
	
	public int numOfContributors() {
		return sourceContributions.keySet().size();
	}
	
	public int contributionsFromSource(Synapse<T> source) {
		return (sourceContributions.get(source) == null) ? 0 :sourceContributions.get(source); 
	}
	
	public Stimulus<T> sampleItemFromCluster(){
		int sample = (int) Math.floor(r.nextDouble() * (double)items.size());
		return items.get(sample);
	}
	
	public Vocabulary<T> getLocalVocabulary(){
		return null;
	}
	
	public Collection<InputStream> groupStreams(){
		return null;
	}
	
	public InputStream mergedStream() {
		return null;
	}
}
