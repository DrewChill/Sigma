package ml.kit.function.gaussian;

import java.util.Random;

import ml.kit.function.SymbolFunction;
import ml.kit.types.DoubleType;

public class GaussianSymbol extends Gaussian{
	
	static Random r = new Random(System.currentTimeMillis());
	private final double dataRange;
	
	public GaussianSymbol(double stdDev, double dataRange) {
		super(r.nextDouble() * dataRange, stdDev);
		this.dataRange = dataRange;
	}
	
	public GaussianSymbol(double meanMin, double meanMax, double stdDevMin, double stdDevMax, double dataRange) {
		super(meanMin, meanMax, stdDevMin, stdDevMax);
		this.dataRange = dataRange;
		this.mean = r.nextDouble() * dataRange;
		this.stdDev = r.nextDouble() * (dataRange/10.0);
	}

	@Override
	public double calculate(DoubleType data) {
		double sqrt2PI = stdDev * Math.sqrt(2.0*Math.PI);
		double d2 = Math.pow((data.value - mean),2);
		double std2 = Math.pow(stdDev, 2.0);
		return Math.exp(-d2/(2.0*std2))/sqrt2PI;
	}
	
	@Override
	public SymbolFunction<DoubleType> initNext(){
		if(isFixed) {
			return new GaussianSymbol(stdDev, dataRange);
		}else {
			return new GaussianSymbol(meanMin, meanMax, stdDevMin, stdDevMax, dataRange);
		}
	}

}
