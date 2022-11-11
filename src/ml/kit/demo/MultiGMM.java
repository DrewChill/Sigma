package ml.kit.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.math3.distribution.GammaDistribution;

import ml.kit.function.demo.DoubleTie;
import ml.kit.function.gaussian.GaussianSymbol;
import ml.kit.generators.GaussianGenerator;
import archive.Context;
import archive.AbstractEmitter;
import archive.grpcontext.dp.DPContext;
import archive.StochasticSymbol;
import ml.kit.observer.AbstractObserver;
import ml.kit.observer.symbol.SymbolFilter;
import ml.kit.observer.ObserverLocality;
import ml.kit.observer.symbol.relation.RelationShape;
import ml.kit.observer.ObserverBasis;
import ml.kit.types.DoubleType;

public class MultiGMM {

	public static void main(String[] args) {
		double range = 2000.0;
		// GaussianDensity pdf = new GaussianDensity(5.0, range);
		GaussianSymbol pdf = new GaussianSymbol(Double.MIN_VALUE, Double.MAX_VALUE, 2.0, 2000.0, range);
		// GaussianDistance pdf = new GaussianDistance(5.0, range);
		double gamma = new GammaDistribution(1, 1).sample();
		ObserverBasis<Double> gammaParam = new ObserverBasis<Double>(gamma, "gamma");
		AbstractObserver<DoubleType> mixtureModel = new AbstractObserver<DoubleType>(RelationShape.DP,
				SymbolFilter.LINEAR, ObserverLocality.GLOBAL, pdf, gammaParam);

		Context<DoubleType> gmm = new DPContext<DoubleType>(mixtureModel);
		AbstractEmitter<DoubleType> mono = gmm.addInputStream();
		Random r = new Random(System.currentTimeMillis());

		// -------------1---------------
		GaussianGenerator g1 = new GaussianGenerator("1", range * r.nextDouble(), 2.0);
		GaussianGenerator g2 = new GaussianGenerator("1", range * r.nextDouble(), 3.0);
		// g1.addNested(g2);
		GaussianGenerator g3 = new GaussianGenerator("1", range * r.nextDouble(), 3.0);
		g1.addNested(g3);
		GaussianGenerator g9 = new GaussianGenerator("1", range * r.nextDouble(), 3.0);
		g1.addNested(g9);
		GaussianGenerator g4 = new GaussianGenerator("1", range * r.nextDouble(), 4.0);
		g4.addNested(g9);
		g4.addNested(g2);
		// g4.addNested(g3);

		// -------------2---------------
		GaussianGenerator g7 = new GaussianGenerator("2", range * r.nextDouble(), 5.5);
		GaussianGenerator g8 = new GaussianGenerator("2", range * r.nextDouble(), 3.0);
		GaussianGenerator g5 = new GaussianGenerator("2", range * r.nextDouble(), 3.0);
		GaussianGenerator g6 = new GaussianGenerator("2", range * r.nextDouble(), 3.0);
		g7.addNested(g5);
		g7.addNested(g6);
		g7.addNested(g8);

		// -------------3---------------
		GaussianGenerator g10 = new GaussianGenerator("3", range * r.nextDouble(), 6.0);
		GaussianGenerator g20 = new GaussianGenerator("3", range * r.nextDouble(), 3.0);
		g10.addNested(g20);

		// -------------4---------------
		GaussianGenerator g11 = new GaussianGenerator("4", range * r.nextDouble(), 4.0);
		GaussianGenerator g21 = new GaussianGenerator("4", range * r.nextDouble(), 3.0);
		GaussianGenerator g22 = new GaussianGenerator("4", range * r.nextDouble(), 3.0);
		g11.addNested(g21);
		g11.addNested(g22);
		GaussianGenerator g12 = new GaussianGenerator("4", range * r.nextDouble(), 5.0);
		g12.addNested(g21);
		g12.addNested(g22);

		mono.addData(g1.generateValues(800));
		mono.addData(g4.generateValues(600));
		mono.addData(g7.generateValues(700));
		mono.addData(g10.generateValues(400));
		mono.addData(g11.generateValues(500));
		mono.addData(g12.generateValues(300));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collection<StochasticSymbol<DoubleType>> symbols2 = gmm.processQueue();
		int total2 = 0;
		for (StochasticSymbol<DoubleType> symbol : symbols2) {
			if (symbol.clusterSize() > 0) {
				// System.out.println("size: "+symbol.clusterSize());
				total2 += symbol.clusterSize();
			}
		}
		// System.out.println("total: "+total2);
		Collection<StochasticSymbol<DoubleType>> symbols = gmm.digestInformation(200000);
		int total = 0;
		for (StochasticSymbol<DoubleType> symbol : symbols) {
			if (symbol.clusterSize() > 0) {
				System.out.println("size: " + symbol.clusterSize());
				total += symbol.clusterSize();
			}
		}

		System.out.println("total: " + total);

		// -----------------------------------------

		double range2 = 1000.0;
		GaussianSymbol pdf2 = new GaussianSymbol(3.0, range2);
		// GaussianDensity pdf = new
		// GaussianDensity(Double.MIN_VALUE,Double.MAX_VALUE,Double.MIN_VALUE,Double.MAX_VALUE,
		// range);
		// GaussianDistance pdf = new GaussianDistance(5.0, range);
		double gamma2 = new GammaDistribution(1, 1).sample();
		ObserverBasis<Double> gammaParam2 = new ObserverBasis<Double>(gamma2, "gamma");
		AbstractObserver<DoubleType> mixtureModel2 = new AbstractObserver<DoubleType>(RelationShape.DP,
				SymbolFilter.LINEAR, ObserverLocality.GLOBAL, pdf2, gammaParam2);

		Context<DoubleType> gmm2 = new DPContext<DoubleType>(mixtureModel2);
		AbstractEmitter<DoubleType> mono2 = gmm2.addInputStream();
		for (StochasticSymbol<DoubleType> symbol : symbols) {
			for (int i = 0; i < symbol.clusterSize(); i++) {
				DoubleType dt = symbol.sample();
				if (dt.children.size() > 1) {
					// System.out.println("tied");
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
		Collection<StochasticSymbol<DoubleType>> symbols3 = gmm2.processQueue();
		int total3 = 0;
		for (StochasticSymbol<DoubleType> symbol : symbols3) {
			if (symbol.clusterSize() > 0) {
				// .out.println("size3: "+symbol.clusterSize());
				total3 += symbol.clusterSize();
			}
		}
		System.out.println("total3: " + total3);
		Collection<StochasticSymbol<DoubleType>> symbols4 = gmm2.digestInformation(40000);
		int total4 = 0;
		Map<String, Integer> counts = new HashMap<>();
		for (StochasticSymbol<DoubleType> symbol : symbols4) {
			if (symbol.clusterSize() > 0) {
				System.out.println("size4: " + symbol.clusterSize());
				total4 += symbol.clusterSize();
			}
		}

		System.out.println("total4: " + total4);

		// -----------------------------------------
		List<StochasticSymbol<DoubleType>> clusters = new ArrayList<>();
		for (StochasticSymbol<DoubleType> cluster : symbols) {
			if (cluster.clusterSize() > 1) {
				clusters.add(cluster);
			}
		}
		DoubleTie.clusters = clusters;
		DoubleTie pdf3 = new DoubleTie();
		// GaussianDensity pdf = new
		// GaussianDensity(Double.MIN_VALUE,Double.MAX_VALUE,Double.MIN_VALUE,Double.MAX_VALUE,
		// range);
		// GaussianDistance pdf = new GaussianDistance(5.0, range);
		double gamma3 = new GammaDistribution(1, 1).sample();
		ObserverBasis<Double> gammaParam3 = new ObserverBasis<Double>(gamma3, "gamma");
		AbstractObserver<StochasticSymbol<DoubleType>> mixtureModel3 = new AbstractObserver<StochasticSymbol<DoubleType>>(RelationShape.DP,
				SymbolFilter.LINEAR, ObserverLocality.GLOBAL, pdf3, gammaParam3);

		Context<StochasticSymbol<DoubleType>> gmm3 = new DPContext<StochasticSymbol<DoubleType>>(mixtureModel3);
		AbstractEmitter<StochasticSymbol<DoubleType>> mono3 = gmm3.addInputStream();
		for (StochasticSymbol<DoubleType> symbol : symbols4) {
//			for(int i=1; i < symbol.clusterSize(); i++) {
//				mono3.addData(symbol);
//			}
			if (symbol.clusterSize() > 1)
				mono3.addData(symbol);
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collection<StochasticSymbol<StochasticSymbol<DoubleType>>> symbols5 = gmm3.processQueue();
		int total5 = 0;
		for (StochasticSymbol<StochasticSymbol<DoubleType>> symbol : symbols5) {
			if (symbol.clusterSize() > 0) {
				// .out.println("size3: "+symbol.clusterSize());
				total5 += symbol.clusterSize();
			}
		}
		System.out.println("total5: " + total5);
		Collection<StochasticSymbol<StochasticSymbol<DoubleType>>> symbols6 = gmm3.digestInformation(20);
		int total6 = 0;
		// Map<String, Integer> counts = new HashMap<>();
		for (StochasticSymbol<StochasticSymbol<DoubleType>> symbol : symbols6) {
			if (symbol.clusterSize() > 0) {
				System.out.println("size6: " + symbol.clusterSize());
				total6 += symbol.clusterSize();
			}
		}

		System.out.println("total6: " + total6);
		int k = 1;
		// ------FULLY FORMED STRUCTURES-------
		System.out.println("--------ESTIMATED MIXTURE STRUCTURES-------");
		for (StochasticSymbol<StochasticSymbol<DoubleType>> symbol : symbols6) {
			System.out.println("Generator #" + k + ":");
			System.out.println("     Top level stdDev/mean probabilities:");
			DoubleTie dt = (DoubleTie) symbol.fk;
			for (StochasticSymbol<DoubleType> p : dt.joint.keySet()) {
				Double prob = dt.joint.get(p);
				double mean = ((GaussianSymbol) p.fk).mean;
				double stdDev = ((GaussianSymbol) p.fk).stdDev;
				System.out.println("                     (s:" + stdDev + ")->(" + mean + ") -> " + prob);
			}
			System.out.println("     Second level mean probabilities:");
			for (Map.Entry<StochasticSymbol<DoubleType>, Double> entry : symbol.observationHistory.getStationaryDistribution()
					.entrySet()) {
				double mean = ((GaussianSymbol) entry.getKey().fk).mean;
				double stdDev = ((GaussianSymbol) entry.getKey().fk).stdDev;
				System.out.println("                     (s:" + stdDev + ")->(" + mean + ") -> " + entry.getValue());
			}
			k++;
		}
		System.out.println("\n\n-------TRUTH MIXTURE STRUCTURES-------");
		g1.print(0);
		g4.print(0);
		g7.print(0);
		g10.print(0);
		g11.print(0);
		g12.print(0);
	}

}
