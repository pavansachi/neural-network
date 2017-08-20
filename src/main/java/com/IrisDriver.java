package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.net.impl.FeedForwardNetwork;

public class IrisDriver {

	public static void main(String[] args) throws IOException {

		FeedForwardNetwork net = new FeedForwardNetwork(4, 1);

		double[][] inputs = new double[100][4];
		double[] outputs = new double[100];

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

				double output = Double.valueOf(data[4]);

				if (output == 0 || output == 1) {
					
					inputs[idx] = input;
					outputs[idx] = output;
				}
				
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
