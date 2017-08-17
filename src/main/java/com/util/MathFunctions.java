package com.util;

public class MathFunctions {

	public static double sigmoid (double x) {

		Function sigmoid = v -> 1 / (1 + Math.exp(-v));

		return sigmoid.get(x);
	}

	public static double dSigmoid (double x) {

		Function func = v -> v * (1 -v);

		return func.get(x);
	}
}