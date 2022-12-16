package ml.observer;

public class ObserverBasis<T> {
	
	T value;
	String name;
	
	public ObserverBasis(T value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public T getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}
	
	public Class<?> getType(){
		return value.getClass();
	}

}
