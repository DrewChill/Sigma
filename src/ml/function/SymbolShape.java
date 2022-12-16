package ml.function;

import java.util.Map;

public abstract class SymbolShape<T> {
	
	public abstract double calculate(T data);
	
	public abstract void update(Map<T, Integer> dataMembers);
	
	public abstract SymbolShape<T> initNext();

}
