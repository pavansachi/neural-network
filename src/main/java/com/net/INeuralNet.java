package com.net;

/**
 * Neural network interface
 * @author pavansachi
 *
 */
public interface INeuralNet {

	/**
	 * Train the neural network
	 * @param inputs
	 * @param output
	 */
	public void train (double[][] inputs, double[] output)
			throws NetworkException;
	
	/**
	 * Predict using the trained model
	 * @param inputs
	 * @return output
	 */
	public double predict (double[] inputs);
	
	/**
	 * Print the model
	 */
	public void printModel();
		
}
