package ml.kit.function.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import ml.kit.function.DensityFunction;
import ml.kit.symbol.Symbol;
import ml.kit.types.DoubleType;

public class DoubleTie extends DensityFunction<Symbol<DoubleType>>{
	
	public Map<Symbol<DoubleType>, Double> joint = new HashMap<>();
	Map<Symbol<DoubleType>, Integer> pCount = new HashMap<>();
	public static List<Symbol<DoubleType>> clusters = null;
	Random r = new Random(System.currentTimeMillis());

	@Override
	public double calculate(Symbol<DoubleType> data) {
		// TODO Auto-generated method stub
		DoubleType dt = data.sampleItemFromCluster();
		Symbol<DoubleType> p = sampleP(dt.parent);
		Integer c = pCount.get(p);
		return joint.get(p) == null ? 0.0 : c.doubleValue()*joint.get(p);
	}

	@Override
	public void update(Map<Symbol<DoubleType>, Integer> dataMembers) {
		int total = 0;
		for(Symbol<DoubleType> symbol : dataMembers.keySet()) {
			Integer count = dataMembers.get(symbol);
			total += (count*symbol.clusterSize());
		}
		
		joint = new HashMap<>();
		pCount = new HashMap<>();
		for(Symbol<DoubleType> symbol : dataMembers.keySet()) {
			Integer count = dataMembers.get(symbol)*symbol.clusterSize();
			for(int i=0;i<count;i++) {
				DoubleType parent = symbol.sampleItemFromCluster().parent;
				Symbol<DoubleType> p = sampleP(parent);
				//System.out.println(parent.value);
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
	
	private Symbol<DoubleType> sampleP(DoubleType item){		
		Map<Symbol<DoubleType>, Double> likelihoodForSymbol = new HashMap<>();
		for (Symbol<DoubleType> cluster : clusters) {
			double likelihood = cluster.calcAssignmentLikelihood(item, 0, 0);
			likelihoodForSymbol.put(cluster, likelihood);
		}
		
		double pSum = 0.0;
		double[] p = new double[clusters.size()];
		int index = 0;

		for (Symbol<DoubleType> cluster : clusters) {
			Double likelihood = likelihoodForSymbol.get(cluster);
			likelihood = likelihood == null ? 0.0 : likelihood;
			pSum += likelihood;
			p[index] = pSum;
			index++;
		}
		p[p.length - 1] = pSum;
		
		Symbol<DoubleType> ret = null;
		double clusterSelector = r.nextDouble() * pSum;
		for (int i = 0; i < p.length; i++) {
			//System.out.print(p[i]+",");
			if (clusterSelector < p[i]) {
				ret = clusters.get(i);
				break;
			}
		}
		//System.out.println(" ----> "+ret);
		return ret;
	}

	@Override
	public DensityFunction<Symbol<DoubleType>> initNext() {
		// TODO Auto-generated method stub
		return new DoubleTie();
	}

}
