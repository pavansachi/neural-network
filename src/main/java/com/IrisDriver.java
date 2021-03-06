package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.net.NetworkException;
import com.net.impl.NeuralNetwork;
import com.util.MathFunction;

public class IrisDriver {

	public static void main(String[] args) throws IOException, NetworkException {

		NeuralNetwork net = new NeuralNetwork.Builder()
				.inputs(4)
				.outputs(1)
				.activationFunction(MathFunction.step)
				.learningRate(0.02)
				.iterations(1000)
				.build();

		double[][] inputs = new double[50][4];
		double[][] outputs = new double[50][1];

		String line = null;

		int idx = 0;

		try(BufferedReader reader = new BufferedReader(new FileReader("data/iris.data"))) {
			while ((line = reader.readLine()) != null) {

				String[] data = line.split("\t");

				double[] input = {
						Double.valueOf(data[0]),
						Double.valueOf(data[1]),
						Double.valueOf(data[2]),
						Double.valueOf(data[3])
				};

				double[] output = { 
					Double.valueOf(data[4]) 
				};

				inputs[idx] = input;
				outputs[idx] = output;

				idx++;
			}
		}

		net.train(inputs, outputs);

		net.predict(new double[] {
				//				5.1,3.5,1.4,0.2
				//				5.7,4.4,1.5,0.4
				//				6.8,2.8,4.8,1.4
				//				5.0,3.2,1.2,0.2
				//				6.7,3.1,4.4,1.4
				4.7,3.2,1.6,0.2
		});

		net.printModel();
	}
}
