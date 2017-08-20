package com;

import com.net.impl.NeuralNetwork;

public class Driver {

	public static void main(String[] args) {

		NeuralNetwork net = new NeuralNetwork(2, 1, 0.02);

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
