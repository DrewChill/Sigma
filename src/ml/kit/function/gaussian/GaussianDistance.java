package ml.kit.function.gaussian;

import java.util.Random;

import ml.kit.function.DensityFunction;
import ml.kit.types.DoubleType;

public class GaussianDistance extends Gaussian {
	
	static Random r = new Random(System.currentTimeMillis());
	private final double dataRange;
	
	public GaussianDistance(double stdDev, double dataRange) {
		super(r.nextDouble() * dataRange, stdDev);
		this.dataRange = dataRange;
	}
	
	public GaussianDistance(double meanMin, double meanMax, double stdDevMin, double stdDevMax, double dataRange) {
		super(meanMin, meanMax, stdDevMin, stdDevMax);
		this.dataRange = dataRange;
		this.mean = r.nextDouble() * dataRange;
	}

	@Override
	public double calculate(DoubleType data) {
		double z = (data.value - mean)/stdDev;
		return Math.abs(1.0/z);
	}
	
	@Override
	public DensityFunction<DoubleType> initNext(){
		if(isFixed) {
			return new GaussianDistance(stdDev, dataRange);
		}else {
			return new GaussianDistance(meanMin, meanMax, stdDevMin, stdDevMax, dataRange);
		}
	}

}
