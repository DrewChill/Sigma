package ml.kit.function.gaussian;

import java.util.Map;

import ml.kit.function.DensityFunction;
import ml.kit.types.DoubleType;

public abstract class Gaussian extends DensityFunction<DoubleType> {
	
	protected double mean = Double.MIN_VALUE;
	protected double stdDev = Double.MIN_VALUE;
	
	private double meanMin = Double.MIN_VALUE;
	private double stdDevMin = Double.MIN_VALUE;
	
	private double meanMax = Double.MAX_VALUE;
	private double stdDevMax = Double.MAX_VALUE;
	
	private final boolean isFixed;
	
	public Gaussian(double mean, double stdDev) {
		isFixed = true;
		this.mean = mean;
		this.stdDev = stdDev;
	}
	
	public Gaussian(double meanMin, double meanMax, double stdDevMin, double stdDevMax) {
		isFixed = false;
		this.meanMin = meanMin;
		this.meanMax = meanMax;
		this.stdDevMin = stdDevMin;
		this.stdDevMax = stdDevMax;
	}
	
	@Override
	public void update(Map<DoubleType, Integer> dataMembers) {
		if(!isFixed) {
			double sum = 0.0;
			double nPoints = 0.0;
			for(Map.Entry<DoubleType, Integer> point : dataMembers.entrySet()) {
				nPoints += point.getValue();
				sum += point.getValue() * point.getKey().value;
			}
			mean = sum/nPoints;
			mean = mean < meanMin ? meanMin : mean;
			mean = mean > meanMax ? meanMax : mean;
			
			double sdSum = 0.0;
			for(Map.Entry<DoubleType, Integer> point : dataMembers.entrySet()) {
				sdSum += point.getValue() * Math.pow(mean - point.getKey().value, 2);
			}
			double sdMean = sdSum/nPoints;
			stdDev = Math.sqrt(sdMean);
			stdDev = stdDev < stdDevMin ? stdDevMin : stdDev;
			stdDev = stdDev < stdDevMax ? stdDevMax : stdDev;
		}
	}

}
