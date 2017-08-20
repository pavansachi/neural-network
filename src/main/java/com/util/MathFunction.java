package com.util;

public class MathFunction {

	public static java.util.function.Function<Double, Double> sigmoid = v -> 1 / (1 + Math.exp(-v));
	
	public static java.util.function.Function<Double, Double> dSigmoid = v -> v * (1 -v);
	
	public static java.util.function.Function<Double, Double> step = v -> v > 1.0? 1.0: 0;
	
	public static Double random() {
		return 2 * Math.random() - 1;
	}
	
}