package ml.kit.cluster.entropy;

import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Entropy<T> {
	
	private Map<T, Integer> countForObject= new HashMap<>();
	private volatile int size = 0;
	
	private Map<T, ByteBuffer> compressionCache = null;
	private volatile double entropyCache = 0;
	private volatile boolean dirtyFlag = true;
	
	public void addObservation(T addedObject) {
		synchronized(countForObject) {
			dirtyFlag = true;
			Integer count = countForObject.get(addedObject);
			if(count == null) {
				count = 0;
				countForObject.put(addedObject, count);
			}
			count++;
		}
	}
	
	public void decayObservation(T decayedObject) {
		synchronized(countForObject) {
			dirtyFlag = true;
			Integer count = countForObject.get(decayedObject);
			if(count == null) {
				count = 0;
				countForObject.put(decayedObject, count);
			}
			count--;
		}
	}
	
	public Map<T, ByteBuffer> getCompressedInformationSpace(){
		if(!dirtyFlag) return compressionCache;
		Map<T, ByteBuffer> compressionMapping = new HashMap<>();
		synchronized(countForObject) {
			double avgLength = 0.0;
			for(T obj : countForObject.keySet()) {
				double count = (double)countForObject.get(obj);
				double p = count / (double)size;
				double length = log2(p);
				
				compressionMapping.put(obj, ByteBuffer.allocate((int)Math.ceil(length)));
				avgLength += p*log2(p);
			}
			entropyCache = avgLength;
			dirtyFlag = false;
		}
		compressionCache = compressionMapping;
		return compressionMapping;
	}
	
	public double getCrossEntropy(Entropy<T> compare) {
		return 0.0;
	}
	
	public double getKLDivergence(Entropy<T> compare) {
		return 0.0;
	}
	
	public static double log2(double p){
	    return Math.log(p) / Math.log(2.0);
	}

}
