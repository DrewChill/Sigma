package ml.kit.structs.item;

import ml.kit.cluster.Cluster;
import ml.kit.structs.group.Group;

public class Item<T> {
	
	private Group<T> source;
	private Cluster<T> assignment = null;
	private T value;
	
	public Item(T value, Group<T> source){
		this.value = value;
		this.source = source;
	}
	
	public T getValue() { return value; };
	
	public void setAssignment(Cluster<T> assignment) {
		this.assignment = assignment;
	}
	
	public void removeAssignment() {
		assignment.removeElement(this);
	}
	
	public Group<T> getSource(){
		return source;
	}
	
	@Override
	public boolean equals(Object otherItem) {
		if(otherItem == null) return false;
		
		if(otherItem instanceof Item<?>) {
			Item<?> otherCast = (Item<?>)otherItem;
			return otherCast.assignment.equals(assignment);
		}else {
			return false;
		}
	}
}
