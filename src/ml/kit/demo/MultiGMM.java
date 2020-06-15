package ml.kit.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.math3.distribution.GammaDistribution;

import ml.kit.function.demo.DoubleTie;
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

public class MultiGMM {

	public static void main(String[] args) {
		double range = 3000.0;
		GaussianDensity pdf = new GaussianDensity(5.0, range);
		// GaussianDensity pdf = new
		// GaussianDensity(Double.MIN_VALUE,Double.MAX_VALUE,Double.MIN_VALUE,Double.MAX_VALUE,
		// range);
		// GaussianDistance pdf = new GaussianDistance(5.0, range);
		double gamma = new GammaDistribution(1, 1).sample();
		StructureParameter<Double> gammaParam = new StructureParameter<Double>(gamma, "gamma");
		StructureInfo<DoubleType> mixtureModel = new StructureInfo<DoubleType>(InferenceStructure.DP,
				InferenceFlow.LINEAR, InferenceLocality.GLOBAL, pdf, gammaParam);

		Context<DoubleType> gmm = new DPContext<DoubleType>(mixtureModel);
		Synapse<DoubleType> mono = gmm.addInputStream();
		Random r = new Random(System.currentTimeMillis());
		GaussianGenerator g1 = new GaussianGenerator("1", range * r.nextDouble(), 5.0);
		GaussianGenerator g2 = new GaussianGenerator("2", range * r.nextDouble(), 3.0);
		g1.addNested(g2);
		GaussianGenerator g3 = new GaussianGenerator("3", range * r.nextDouble(), 3.0);
		g1.addNested(g3);

		GaussianGenerator g4 = new GaussianGenerator("4", range * r.nextDouble(), 5.0);
		GaussianGenerator g5 = new GaussianGenerator("5", range * r.nextDouble(), 3.0);
		GaussianGenerator g6 = new GaussianGenerator("6", range * r.nextDouble(), 3.0);
		g4.addNested(g5);
		g4.addNested(g6);

		mono.addData(g1.generateValues(600));
		mono.addData(g4.generateValues(300));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collection<Symbol<DoubleType>> symbols2 = gmm.processQueue();
		int total2 = 0;
		for (Symbol<DoubleType> symbol : symbols2) {
			if (symbol.clusterSize() > 0) {
				// System.out.println("size: "+symbol.clusterSize());
				total2 += symbol.clusterSize();
			}
		}
		// System.out.println("total: "+total2);
		Collection<Symbol<DoubleType>> symbols = gmm.digestInformation(20000);
		int total = 0;
		for (Symbol<DoubleType> symbol : symbols) {
			if (symbol.clusterSize() > 0) {
				System.out.println("size: " + symbol.clusterSize());
				total += symbol.clusterSize();
			}
		}

		System.out.println("total: " + total);

		// -----------------------------------------

		double range2 = 1000.0;
		GaussianDensity pdf2 = new GaussianDensity(3.0, range2);
		// GaussianDensity pdf = new
		// GaussianDensity(Double.MIN_VALUE,Double.MAX_VALUE,Double.MIN_VALUE,Double.MAX_VALUE,
		// range);
		// GaussianDistance pdf = new GaussianDistance(5.0, range);
		double gamma2 = new GammaDistribution(1, 1).sample();
		StructureParameter<Double> gammaParam2 = new StructureParameter<Double>(gamma2, "gamma");
		StructureInfo<DoubleType> mixtureModel2 = new StructureInfo<DoubleType>(InferenceStructure.DP,
				InferenceFlow.LINEAR, InferenceLocality.GLOBAL, pdf2, gammaParam2);

		Context<DoubleType> gmm2 = new DPContext<DoubleType>(mixtureModel2);
		Synapse<DoubleType> mono2 = gmm2.addInputStream();
		for (Symbol<DoubleType> symbol : symbols) {
			for (int i = 0; i < symbol.clusterSize(); i++) {
				DoubleType dt = symbol.sampleItemFromCluster();
				if (dt.children.size() > 1) {
					//System.out.println("tied");
				}
				mono2.addData(dt.children);

			}
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collection<Symbol<DoubleType>> symbols3 = gmm2.processQueue();
		int total3 = 0;
		for (Symbol<DoubleType> symbol : symbols3) {
			if (symbol.clusterSize() > 0) {
				// .out.println("size3: "+symbol.clusterSize());
				total3 += symbol.clusterSize();
			}
		}
		System.out.println("total3: " + total3);
		Collection<Symbol<DoubleType>> symbols4 = gmm2.digestInformation(20000);
		int total4 = 0;
		Map<String, Integer> counts = new HashMap<>();
		for (Symbol<DoubleType> symbol : symbols4) {
			if (symbol.clusterSize() > 0) {
				System.out.println("size4: " + symbol.clusterSize());
				total4 += symbol.clusterSize();
			}
		}

		System.out.println("total4: " + total4);

		// -----------------------------------------
		DoubleTie.pGen = gmm.vocabulary;
		DoubleTie pdf3 = new DoubleTie();
		// GaussianDensity pdf = new
		// GaussianDensity(Double.MIN_VALUE,Double.MAX_VALUE,Double.MIN_VALUE,Double.MAX_VALUE,
		// range);
		// GaussianDistance pdf = new GaussianDistance(5.0, range);
		double gamma3 = new GammaDistribution(1, 1).sample();
		StructureParameter<Double> gammaParam3 = new StructureParameter<Double>(gamma3, "gamma");
		StructureInfo<Symbol<DoubleType>> mixtureModel3 = new StructureInfo<Symbol<DoubleType>>(InferenceStructure.DP,
				InferenceFlow.LINEAR, InferenceLocality.GLOBAL, pdf3, gammaParam3);

		Context<Symbol<DoubleType>> gmm3 = new DPContext<Symbol<DoubleType>>(mixtureModel3);
		Synapse<Symbol<DoubleType>> mono3 = gmm3.addInputStream();
		for (Symbol<DoubleType> symbol : symbols4) {
			mono3.addData(symbol);
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collection<Symbol<Symbol<DoubleType>>> symbols5 = gmm3.processQueue();
		int total5 = 0;
		for (Symbol<Symbol<DoubleType>> symbol : symbols5) {
			if (symbol.clusterSize() > 0) {
				// .out.println("size3: "+symbol.clusterSize());
				total5 += symbol.clusterSize();
			}
		}
		System.out.println("total5: " + total5);
		Collection<Symbol<Symbol<DoubleType>>> symbols6 = gmm3.digestInformation(20000);
		int total6 = 0;
		//Map<String, Integer> counts = new HashMap<>();
		for (Symbol<Symbol<DoubleType>> symbol : symbols6) {
			if (symbol.clusterSize() > 0) {
				System.out.println("size6: " + symbol.clusterSize());
				total6 += symbol.clusterSize();
			}
		}

		System.out.println("total6: " + total6);
	}

}
