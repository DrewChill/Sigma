package ml.kit.function;

import java.util.Map;

public abstract class DensityFunction<T> {
	
	public abstract double calculate(T data);
	
	public abstract void update(Map<T, Integer> dataMembers);
	
	public abstract DensityFunction<T> initNext();

}
