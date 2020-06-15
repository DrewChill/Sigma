package ml.kit.demo;

import java.util.Collection;
import java.util.Random;

import org.apache.commons.math3.distribution.GammaDistribution;

import ml.kit.function.gaussian.GaussianDensity;
import ml.kit.function.gaussian.GaussianDistance;
import ml.kit.generators.GaussianGenerator;
import ml.kit.structs.group.Context;
import ml.kit.structs.group.Synapse;
import ml.kit.structs.impl.dp.DPContext;
import ml.kit.symbol.Symbol;
import ml.kit.symbol.structure.StructureInfo;
import ml.kit.symbol.structure.StructureInfo.InferenceFlow;
import ml.kit.symbol.structure.StructureInfo.InferenceLocality;
import ml.kit.symbol.structure.StructureInfo.InferenceStructure;
import ml.kit.symbol.structure.StructureParameter;
import ml.kit.types.DoubleType;

public class GMM {

	public static void main(String[] args) {
		double range = 1000.0;
		GaussianDensity pdf = new GaussianDensity(5.0, range);
		//GaussianDensity pdf = new GaussianDensity(Double.MIN_VALUE,Double.MAX_VALUE,Double.MIN_VALUE,Double.MAX_VALUE, range);
		//GaussianDistance pdf = new GaussianDistance(5.0, range);
		double gamma = new GammaDistribution(1, 1).sample();
		StructureParameter<Double> gammaParam = new StructureParameter<Double>(gamma, "gamma");
		StructureInfo<DoubleType> mixtureModel = new StructureInfo<DoubleType>(InferenceStructure.DP,
				InferenceFlow.LINEAR, InferenceLocality.GLOBAL, pdf, gammaParam);
		
		Context<DoubleType> gmm = new DPContext<DoubleType>(mixtureModel);
		Synapse<DoubleType> mono = gmm.addInputStream();
		Random r = new Random(System.currentTimeMillis());
		GaussianGenerator g1 = new GaussianGenerator("1", range * r.nextDouble(), 5.0);
		GaussianGenerator g2 = new GaussianGenerator("2", range * r.nextDouble(), 5.0);
		GaussianGenerator g3 = new GaussianGenerator("3", range * r.nextDouble(), 5.0);
		GaussianGenerator g4 = new GaussianGenerator("4", range * r.nextDouble(), 5.0);
		
		mono.addData(g1.generateValues(100));
		mono.addData(g2.generateValues(200));
		mono.addData(g3.generateValues(50));
		mono.addData(g4.generateValues(400));
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collection<Symbol<DoubleType>> symbols2 = gmm.processQueue();
		int total2 = 0;
		for(Symbol<DoubleType> symbol : symbols2) {
			if(symbol.clusterSize() > 0) {
				//System.out.println("size: "+symbol.clusterSize());
				total2 += symbol.clusterSize();
			}
		}
		//System.out.println("total: "+total2);
		Collection<Symbol<DoubleType>> symbols = gmm.digestInformation(20000);
		int total = 0;
		for(Symbol<DoubleType> symbol : symbols) {
			if(symbol.clusterSize() > 0) {
				System.out.println("size: "+symbol.clusterSize());
				total += symbol.clusterSize();
			}
		}
		
		System.out.println("total: "+total);
		
	}

}
