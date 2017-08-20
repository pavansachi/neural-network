package com;

import com.net.NetworkException;
import com.net.impl.NeuralNetwork;

public class Driver {

	public static void main(String[] args) throws NetworkException {

		NeuralNetwork net = new NeuralNetwork.Builder()
				.inputs(2)
				.outputs(1)
				.learningRate(0.02)
				.iterations(100)
				.build();

		net.train(new double[][] {
			{0, 0},
			{0, 1},
			{1, 0},
			{1, 1}
		}, new double[] {
				0,
				1,
				1,
				1
		});

		net.predict(new double[] {
				1, 1
		});

		net.printModel();
	}
}
