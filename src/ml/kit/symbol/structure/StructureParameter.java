package ml.kit.symbol.structure;

public class StructureParameter<T> {
	
	T value;
	String name;
	
	public StructureParameter(T value, String name) {
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
