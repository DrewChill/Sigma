package ml.kit.structs.item;

import java.util.HashMap;
import java.util.Map;

import ml.kit.cluster.Symbol;
import ml.kit.structs.group.Group;

public class Stimulus<T> {
	
	private static Map<Object, Stimulus<?>> stimulusForValue = new HashMap<>();
 	
	public Stimulus(){
		
	}
	
	@SuppressWarnings("unchecked")
	public Stimulus<?> stimulateValue(T value, String groupID){
		Stimulus<T> stimulus = null;
		synchronized(stimulusForValue) {
			stimulus = (Stimulus<T>) stimulusForValue.get(value);
			if(stimulus == null) {
				stimulus = new Stimulus<T>();
				stimulusForValue.put(value, stimulus);
			}
		}
		return stimulus;
	}
	
	public T getValue() { return value; };
	
	@Override
	public boolean equals(Object otherItem) {
		//TODO: KL Divergence
		//		if(otherItem == null) return false;
//		
//		if(otherItem instanceof Stimulus<?>) {
//			Stimulus<?> otherCast = (Stimulus<?>)otherItem;
//			return otherCast.value.equals(value);
//		}else {
//			return false;
//		}
		return false;
	}
}
