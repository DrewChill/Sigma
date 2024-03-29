package ml.kit.symbol.entropy;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LocalEntropy<T> {
	
	private Map<T, Integer> countForObject = new HashMap<>();
	public volatile int size = 0;
	
	private Map<T, Double> compressionCache = new HashMap<>();
	private volatile double entropyCache = 0;
	private volatile boolean dirtyFlag = true;
	private double cost_max = 0.0;
	
	protected LocalEntropy() {
		
	}
	
	public Map<T, Integer> getObjsAndCount(){
		return countForObject;
	}
	
	public Integer observationCount(T obj) {
		Integer count = countForObject.get(obj);
		count = count == null ? 0 : count;
		return count;
	}
	
	public double addObservation(T addedObject) {
		Integer count = null;
		synchronized(countForObject) {
			dirtyFlag = true;
			count = countForObject.get(addedObject);
			if(count == null) {
				count = 0;
			}
			count++;
			size++;
			countForObject.put(addedObject, count);
		}
		return count.doubleValue();
	}
	
	public double decayObservation(T decayedObject) {
		Integer count = null;
		synchronized(countForObject) {
			dirtyFlag = true;
			count = countForObject.get(decayedObject);
			if(count != null) {
				count--;
				size--;
				if(count <= 0) {
					countForObject.remove(decayedObject);
				}else {
					countForObject.put(decayedObject, count);
				}
				return count.doubleValue();
			}
		}
		return 0.0;
	}
	
	public Map<T, ByteBuffer> getCompressedInformation(){
		Map<T, ByteBuffer> compressionMapping = new HashMap<>();
		synchronized(countForObject) {
			if(dirtyFlag) {
				double avgLength = 0.0;
				for(T obj : countForObject.keySet()) {
					double count = (double)countForObject.get(obj);
					double p = count / (double)size;
					double length = log2(p);
					compressionCache.put(obj, length);
					if(length < 1.0) {
						length = 1.0;
					}
					compressionMapping.put(obj, ByteBuffer.allocate((int)Math.ceil(length)));
					avgLength += p*log2(p);
				}
				entropyCache = avgLength;
				dirtyFlag = false;
			}
		}
		return compressionMapping;
	}
	
	public double getCrossEntropy(LocalEntropy<T> compare) {
		Set<T> objects = new HashSet<>();
		objects.addAll(countForObject.keySet());
		double crossEntropy = 0.0;
		for(T obj : objects) {
			Double count = (double)compare.countForObject.get(obj);
			count = count == null ? 0.0 : count;
			
			double p = count / (double)compare.size;
			
			Double cost = compressionCache.get(obj);
			cost = cost == null ? cost_max : cost;
			
			crossEntropy += p*cost;
		}
		return crossEntropy;
	}
	
	public Map<T, Double> getStationaryDistribution() {
		Map<T, Double> objects = new HashMap<>();
		for(T obj : countForObject.keySet()) {
			double count = (double)countForObject.get(obj);
			double p = count / (double)size;
			objects.put(obj, p);
		}
		return objects;
	}
	
	public double getKLDivergence(LocalEntropy<T> compare) {
		return getCrossEntropy(compare) - entropyCache;
	}
	
	public static double log2(double p){
	    return Math.log(p) / Math.log(2.0);
	}

}
