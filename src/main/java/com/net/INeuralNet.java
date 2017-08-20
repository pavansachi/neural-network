package com.net;

public interface INeuralNet {

	public void train (double[][] inputs, double[] output);
	public double predict (double[] inputs);
	
	public void printModel();
		
}
