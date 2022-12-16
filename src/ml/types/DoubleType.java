package ml.types;

import java.util.ArrayList;
import java.util.List;

import archive.asm.Observable;

public class DoubleType extends Observable {

	public final double value;
	public String truth = "";
	
	public DoubleType parent = null;
	
	public List<DoubleType> children = new ArrayList<>();
	
	public DoubleType(double value) {
		this.value = value;
	}
	public DoubleType(double value, String truth) {
		this(value);
		this.truth = truth;
	}
	
}
