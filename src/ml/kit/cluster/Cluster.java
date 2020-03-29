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
import ml.kit.structs.group.Group;
import ml.kit.structs.item.Item;

public abstract class Cluster<T> {
	
	protected List<Item<T>> items;
	protected Map<Group<T>, Integer> sourceContributions;
	
	IndicatorGenerator<T> indicatorGenerator;
	
	byte[] clusterIndicator = null;
	double clusterStrength = 0.0;
	
	private Random r = new Random();
	
	public Cluster(IndicatorGenerator<T> indicatorGenerator) {
		this.indicatorGenerator = indicatorGenerator;
		items = new ArrayList<>();
		sourceContributions = new HashMap<>();
	}
	
	public boolean addOrRejectItem(Item<T> item) {
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
	
	public abstract double calcAssignmentLikelihood(Item<T> item);
	
	public byte[] getIndicator() { return clusterIndicator; };
	
	public void removeElement(Item<T> item) {
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
	
	public Collection<Item<T>> itemList(){
		return items;
	}
	
	public int occurences(T value) {
		int count = 0;
		for(Item<T> item : items) {
			if(item.getValue().equals(value))
				count++;
		}
		return count;
	}
	
	public int numOfContributors() {
		return sourceContributions.keySet().size();
	}
	
	public int contributionsFromSource(Group<T> source) {
		return (sourceContributions.get(source) == null) ? 0 :sourceContributions.get(source); 
	}
	
	public Item<T> sampleItemFromCluster(){
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
