package ml.kit.generators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import ml.kit.types.DoubleType;

public class GaussianGenerator {
	
	public final String name;
	public final double mean;
	public final double stdDev;
	
	private Random r = new Random(System.currentTimeMillis());
	
	private List<GaussianGenerator> nested = new ArrayList<>();
	
	
	public GaussianGenerator(String name, double mean, double stdDev) {
		this.mean = mean;
		this.stdDev = stdDev;
		this.name = name;
	}
	
	public Collection<DoubleType> generateValues(int n){
		List<DoubleType> values = new ArrayList<>();
		System.out.println("generating data...");
		for(int i=0; i<n; i++) {
			double value = mean + (r.nextGaussian() * stdDev);
			DoubleType dVal = new DoubleType(value, name);
			int numNested = (int) Math.floor(r.nextDouble() * nested.size());
			for(int j=0;j<=numNested;j++) {
				GaussianGenerator gen = nested.get((int) Math.floor(r.nextDouble() * nested.size()));
				DoubleType nVal = new DoubleType(gen.mean + (r.nextGaussian() * gen.stdDev), gen.name);
				nVal.parent = dVal;
				dVal.children.add(nVal);
			}
			
			values.add(dVal);
		}
		
		return values;
	}
	
	public void addNested(GaussianGenerator g2) {
		nested.add(g2);
	}
	
	public void print(int tabs) {
		for(int i=0;i<tabs;i++) {
			System.out.print(" ");
		}
		System.out.println("Generator #"+name+":");
		for(int i=0;i<tabs;i++) {
			System.out.print(" ");
		}
		System.out.println("     Top level stdDev/mean:");
		for(int i=0;i<tabs;i++) {
			System.out.print(" ");
		}
		System.out.println("                     (s:"+stdDev+")->("+mean+")");
		if(!nested.isEmpty()) {
			for(int i=0;i<tabs;i++) {
				System.out.print(" ");
			}
			System.out.println("     Second level stdDev/mean:");
			for(GaussianGenerator nest : nested) {
				nest.print(tabs + 10);
			}
		}
		
	}

}
