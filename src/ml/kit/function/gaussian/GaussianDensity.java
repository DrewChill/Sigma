package ml.kit.function.gaussian;

import ml.kit.types.DoubleType;

public class GaussianDensity extends Gaussian{
	
	public GaussianDensity(double mean, double stdDev) {
		super(mean, stdDev);
	}
	
	public GaussianDensity(double meanMin, double meanMax, double stdDevMin, double stdDevMax) {
		super(meanMin, meanMax, stdDevMin, stdDevMax);
	}

	@Override
	public double calculate(DoubleType data) {
		double sqrt2PI = Math.sqrt(2*Math.PI);
		double z = (data.value - mean)/stdDev;
		double eExp = 0.5 * Math.pow(z, 2);
		return (1/(stdDev * sqrt2PI)) * Math.pow(Math.E, eExp);
	}

}
