package ml.demo;

import java.util.Collection;
import java.util.Random;

import org.apache.commons.math3.distribution.GammaDistribution;

import ml.function.gaussian.GaussianSymbol;
import ml.generators.GaussianGenerator;
import archive.Context;
import archive.AbstractEmitter;
import archive.grpcontext.dp.DPContext;
import archive.StochasticSymbol;
import ml.observer.AbstractObserver;
import ml.observer.symbol.SymbolFilter;
import ml.observer.ObserverLocality;
import ml.observer.symbol.relation.RelationShape;
import ml.observer.ObserverBasis;
import ml.types.DoubleType;

public class GMM {

	public static void main(String[] args) {
		double range = 1000.0;
		GaussianSymbol pdf = new GaussianSymbol(5.0, range);
		//GaussianDensity pdf = new GaussianDensity(Double.MIN_VALUE,Double.MAX_VALUE,Double.MIN_VALUE,Double.MAX_VALUE, range);
		//GaussianDistance pdf = new GaussianDistance(5.0, range);
		double gamma = new GammaDistribution(1, 1).sample();
		ObserverBasis<Double> gammaParam = new ObserverBasis<Double>(gamma, "gamma");
		AbstractObserver<DoubleType> mixtureModel = new AbstractObserver<DoubleType>(RelationShape.DP,
				SymbolFilter.LINEAR, ObserverLocality.GLOBAL, pdf, gammaParam);
		
		Context<DoubleType> gmm = new DPContext<DoubleType>(mixtureModel);
		AbstractEmitter<DoubleType> mono = gmm.addInputStream();
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
		Collection<StochasticSymbol<DoubleType>> symbols2 = gmm.processQueue();
		int total2 = 0;
		for(StochasticSymbol<DoubleType> symbol : symbols2) {
			if(symbol.clusterSize() > 0) {
				//System.out.println("size: "+symbol.clusterSize());
				total2 += symbol.clusterSize();
			}
		}
		//System.out.println("total: "+total2);
		Collection<StochasticSymbol<DoubleType>> symbols = gmm.digestInformation(20000);
		int total = 0;
		for(StochasticSymbol<DoubleType> symbol : symbols) {
			if(symbol.clusterSize() > 0) {
				System.out.println("size: "+symbol.clusterSize());
				total += symbol.clusterSize();
			}
		}
		
		System.out.println("total: "+total);
		
	}

}
