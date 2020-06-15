package ml.kit.function.demo;

import java.util.HashMap;
import java.util.Map;

import ml.kit.function.DensityFunction;
import ml.kit.symbol.Symbol;
import ml.kit.symbol.SymbolGenerator;
import ml.kit.types.DoubleType;

public class DoubleTie extends DensityFunction<Symbol<DoubleType>>{
	
	public Map<Symbol<DoubleType>, Double> joint = new HashMap<>();
	Map<Symbol<DoubleType>, Integer> pCount = new HashMap<>();
	public static SymbolGenerator<DoubleType> pGen = null;

	@Override
	public double calculate(Symbol<DoubleType> data) {
		// TODO Auto-generated method stub
		DoubleType dt = data.sampleItemFromCluster();
		Symbol<DoubleType> p = pGen.sample(dt.parent);
		Integer c = pCount.get(p);
		return joint.get(p) == null ? 0.0 : c.doubleValue()*joint.get(p);
	}

	@Override
	public void update(Map<Symbol<DoubleType>, Integer> dataMembers) {
		int total = 0;
		for(Symbol<DoubleType> symbol : dataMembers.keySet()) {
			Integer count = dataMembers.get(symbol);
			total += count;
		}
		
		joint = new HashMap<>();
		pCount = new HashMap<>();
		for(Symbol<DoubleType> symbol : dataMembers.keySet()) {
			Integer count = dataMembers.get(symbol);
			for(int i=0;i<count;i++) {
				DoubleType parent = symbol.sampleItemFromCluster().parent;
				Symbol<DoubleType> p = pGen.sample(parent);
				//System.out.println(parent);
				Integer c = pCount.get(p);
				if(c == null) {
					c = 0;
				}
				c++;
				pCount.put(p,c);
			}
		}
		
		for(Symbol<DoubleType> parent : pCount.keySet()) {
			Integer count = pCount.get(parent);
			joint.put(parent, count.doubleValue()/(double)total);
		}
	}

	@Override
	public DensityFunction<Symbol<DoubleType>> initNext() {
		// TODO Auto-generated method stub
		return new DoubleTie();
	}

}
