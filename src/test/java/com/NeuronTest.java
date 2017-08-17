package com;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.net2.FeedForwardNeuralNet;

public class NeuronTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testForNeuronWeightedSumWith2Inputs() {

		FeedForwardNeuralNet.Neuron outputNeuron = new FeedForwardNeuralNet.Neuron();

		outputNeuron.addConnection(new FeedForwardNeuralNet.Node(1), 0.5);
		outputNeuron.addConnection(new FeedForwardNeuralNet.Node(1), 0.5);

		outputNeuron.calcOutput(FeedForwardNeuralNet.ActivationFunction.sigmoid);

		Assert.assertEquals(FeedForwardNeuralNet.ActivationFunction.sigmoid.get(1), outputNeuron.getOutput(), 0);
	}

	@Test
	public void testForNeuronWeightedSumWith3Inputs() {

		FeedForwardNeuralNet.Neuron outputNeuron = new FeedForwardNeuralNet.Neuron();

		outputNeuron.addConnection(new FeedForwardNeuralNet.Node(1), 0.5);
		outputNeuron.addConnection(new FeedForwardNeuralNet.Node(1), 0.5);
		outputNeuron.addConnection(new FeedForwardNeuralNet.Node(1), 0.5);

		outputNeuron.calcOutput(FeedForwardNeuralNet.ActivationFunction.sigmoid);

		Assert.assertEquals(FeedForwardNeuralNet.ActivationFunction.sigmoid.get(1.5), outputNeuron.getOutput(), 0);

		//		Double truncatedDouble = BigDecimal.valueOf(toBeTruncated)
		//			    .setScale(3, RoundingMode.HALF_UP)
		//			    .doubleValue();

//		Assert.assertEquals(NeuralNet.ActivationFunction.sigmoid.get(0.59), n1.getOutput(), 0);
	}


}
