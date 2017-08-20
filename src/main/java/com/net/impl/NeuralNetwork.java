package com.net.impl;

import java.util.Iterator;

import com.net.AbstractNeuralNet;
import com.net.NetworkException;
import com.net.model.Connection;
import com.net.model.Neuron;
import com.net.model.Node;
import com.util.MathFunction;

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

	public static class Builder {

		private int inputs;
		private int outputs;
		private double learningRate;
		private int numIterations;
		
		public Builder inputs(int n) {

			this.inputs = n;
			return this;
		}

		public Builder outputs(int n) {

			this.outputs = n;
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
					this.numIterations);
		}

	}

	private NeuralNetwork() {

	}

	private NeuralNetwork(int numInputs, int numOutputs, double learningRate, 
			int numIterations) {

		this.numInputs = numInputs;
		this.numOutputs = numOutputs;
		this.learningRate = learningRate;
		this.numIterations = numIterations;

		addNodes(inputLayer, numInputs);
		addNeurons(outputLayer, numOutputs);

		inputLayer.connect(outputLayer);

	}

	@Override
	public void train (double[][] inputArray, double[] outputArray) throws NetworkException {

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

			System.out.printf("Epoch => %s\n", epoch);

			for (int i=0; i< len; i++) {

				double[] inputs = inputArray[i];
				double output = outputArray[i];

				double totalOutput = calcOutput(inputs);

				double error = calcError(output, totalOutput);

				System.out.printf("Error = %s\n", error);

				adjustWeights(error);

			}

			System.out.println();
		}

		while (epoch++ <= numIterations);

		System.out.println();

	}

	@Override
	public double calcOutput(double[] inputs) {

		double totalOutput = 0;

		Iterator<Node> iterator = inputLayer.getNodes().iterator();

		for (double input: inputs) {

			Node node = iterator.next();
			node.setInput(input);

		}

		// output layer
		for (Neuron neuron: outputLayer.getNeurons()) {
			neuron.calcOutput(MathFunction.step);
		}

		for (Neuron neuron: outputLayer.getNeurons()) {
			totalOutput += neuron.getOutput();
		}

		return totalOutput;
	}

	@Override
	public double calcError(double realoutput, double calcOutput) {

		double error = realoutput - calcOutput;

		return error;
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
	public double predict(double[] inputs) {

		double networkOutput = calcOutput(inputs);

		System.out.printf("Output = %s\n\n", networkOutput);

		return networkOutput;
	}

}