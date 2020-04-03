package ml.kit.cluster.vocabulary.inference.impl;

public abstract class Parameter<T> {
	
	T value;
	String name;
	
	public Parameter(T value, String name) {
		this.value = value;
		this.name = name;
	}

}
