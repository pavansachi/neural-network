package com;

import com.net.impl.FeedForwardNetwork;

public class Driver {

	public static void main(String[] args) {

		FeedForwardNetwork net = new FeedForwardNetwork(2, 1);

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
			1, 0
		});
		
		net.printModel();
	}
}
