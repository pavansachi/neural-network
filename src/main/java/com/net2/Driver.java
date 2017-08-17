package com.net2;

import java.util.stream.DoubleStream;

public class Driver {

	public static void main(String[] args) {

		FeedForwardNeuralNet net = new FeedForwardNeuralNet(2, 1);

		net.train(DoubleStream.of(1, 1).toArray(), DoubleStream.of(1).toArray());
	}
}
