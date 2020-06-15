package ml.kit.function.gaussian;

import ml.kit.types.DoubleType;

public class GaussianDistance extends Gaussian {
	
	public GaussianDistance(double mean, double stdDev) {
		super(mean, stdDev);
	}
	
	public GaussianDistance(double meanMin, double meanMax, double stdDevMin, double stdDevMax) {
		super(meanMin, meanMax, stdDevMin, stdDevMax);
	}

	@Override
	public double calculate(DoubleType data) {
		double z = (data.value - mean)/stdDev;
		return 1.0/z;
	}

}
