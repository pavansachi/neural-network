package com.net.impl;

import java.util.function.Function;

import com.net.AbstractNeuralNet;
import com.net.NetworkException;
import com.net.model.Connection;
import com.net.model.Neuron;
import com.net.model.Node;

/**
 * Neural network
 * @author pavansachi
 *
 */
public class NeuralNetwork extends AbstractNeuralNet {

	private double learningRate;
	private int numInputs;
	private int numOutputs;
	private int numIterations;
	private Function<Double, Double> outputActivation;

	public static class Builder {

		private int inputs;
		private int outputs;
		private double learningRate;
		private int numIterations;
		private Function<Double, Double> outputActivation;
		
		public Builder inputs(int n) {

			this.inputs = n;
			return this;
		}

		public Builder outputs(int n, Function<Double, Double> outputActivation) {

			this.outputs = n;
			this.outputActivation = outputActivation;
			return this;
		}
		
		public Builder learningRate(double lr) {

			this.learningRate = lr;
			return this;
		}
		
		public Builder iterations(int i) {

			this.numIterations = i;
			return this;
		}

		public NeuralNetwork build() {

			return new NeuralNetwork(this.inputs,
					this.outputs,
					this.learningRate,
					this.numIterations,
					this.outputActivation);
		}

	}

	private NeuralNetwork() {

	}

	private NeuralNetwork(int numInputs, int numOutputs, double learningRate, 
			int numIterations, Function<Double, Double> function) {

		this.numInputs = numInputs;
		this.numOutputs = numOutputs;
		this.learningRate = learningRate;
		this.numIterations = numIterations;
		this.outputActivation = function;

		addNodes(inputLayer, numInputs);
		addNeurons(outputLayer, numOutputs);

		inputLayer.connect(outputLayer);

	}

	@Override
	public void train (double[][] inputArray, double[][] outputArray) throws NetworkException {

		if (inputArray[0].length !=  numInputs) {

			throw new NetworkException("The network is not configured properly");
		}

//		if (outputArray[0] !=  numOutputs) {
//
//			throw new NetworkException("The network is not configured properly");
//		}

		int len = outputArray.length;

		int epoch = 1;

		do {

			double errors = 0;
			for (int i=0; i< len; i++) {

				double[] inputs = inputArray[i];
				double[] realOutputs = outputArray[i];

				double[] calcOutputs = calcOutput(inputs);

				errors = calcError(realOutputs, calcOutputs);

				adjustWeights(errors);

			}
			
			if (epoch % 100 == 0) {
				System.out.printf("Epoch => %s\n Error = %s\n", epoch, errors);
			}
		}

		while (epoch++ <= numIterations);

		System.out.println();

	}

	@Override
	public double[] calcOutput(double[] inputs) {

		double[] outputs = new double[numOutputs];
		
		for (int i=0; i< numInputs; i++) {
			
			Node node = inputLayer.getNodes().get(i);
			node.setInput(inputs[i]);
		}
		
//		Iterator<Node> iterator = inputLayer.getNodes().iterator();
//
//		for (double input: inputs) {
//
//			Node node = iterator.next();
//			node.setInput(input);
//
//		}

		// output layer
		for (Neuron neuron: outputLayer.getNeurons()) {
			neuron.calcOutput(outputActivation);
		}

		for (int o = 0; o < outputLayer.getNeurons().size(); o++) {
			
			Neuron neuron = outputLayer.getNeurons().get(o);
			outputs[o] = neuron.getOutput();
		}

		return outputs;
	}

	@Override
	public double calcError(double[] realoutput, double[] calcOutput) {

		double errors = 0;
		
		for (int i=0; i< numOutputs; i++) {
			
			double error = realoutput[i] - calcOutput[i];
			error = error * error;
			errors+= error;
		}
		
		return errors;
	}

	@Override
	public void adjustWeights(double error) {

		for (Neuron neuron: outputLayer.getNeurons()) {

			for (Connection conn: neuron.getConnections()) {

				if (conn.getNode() != null) {

					Node node = conn.getNode();

					conn.setWeight(conn.getWeight() + (error * learningRate * node.getInput()));
				}

				if (conn.getNeuron() != null) {

				}

			}

		}
	}

	@Override
	public double[] predict(double[] inputs) {

		double[] networkOutput = calcOutput(inputs);

		for (int i=0; i< numOutputs; i++) {
			
			System.out.printf("Output = %s\n\n", networkOutput[i]);
		}
		
		return networkOutput;
	}

}
