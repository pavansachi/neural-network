package com;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.net.NetworkException;
import com.net.impl.NeuralNetwork;

public class NeuronTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPredictingOROutput() throws NetworkException {

		NeuralNetwork orNetWork = new NeuralNetwork.Builder()
				.inputs(2)
				.outputs(1)
				.learningRate(0.02)
				.iterations(100)
				.build();

		orNetWork.train(new double[][] {
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

		double output = orNetWork.predict(new double[] {
				1, 0
		});

		Assert.assertEquals(1, output, 0);

	}
	
	@Test
	public void testPredictingRandomTestOutput() throws NetworkException {

		NeuralNetwork orNetWork = new NeuralNetwork.Builder()
				.inputs(2)
				.outputs(1)
				.learningRate(0.02)
				.iterations(100)
				.build();

		orNetWork.train(new double[][] {
			{1, 0},
			{1, 1},
		}, new double[] {
				1,
				1,
		});

		double output = orNetWork.predict(new double[] {
				1, 1
		});

		Assert.assertEquals(1, output, 0);

	}
	
	@Test
	public void testPredictingRandomTestOutputForMultipleInputs() throws NetworkException {

		NeuralNetwork orNetWork = new NeuralNetwork.Builder()
				.inputs(3)
				.outputs(1)
				.learningRate(0.02)
				.iterations(100)
				.build();
		
		orNetWork.train(new double[][] {
			{1, 0, 1},
			{1, 1, 0},
			{0, 1, 1},
			{0, 0, 1}
		}, new double[] {
				1,
				0,
				1,
				1
		});

		double output = orNetWork.predict(new double[] {
				0, 1, 0
		});

		Assert.assertEquals(0, output, 0);

	}

	//	@Test
	//	public void testForNeuronWeightedSumWith2Inputs() {
	//
	//		FeedForwardNeuralNet.Neuron outputNeuron = new FeedForwardNeuralNet.Neuron();
	//
	//		outputNeuron.addConnection(new FeedForwardNeuralNet.Node(1), 0.5);
	//		outputNeuron.addConnection(new FeedForwardNeuralNet.Node(1), 0.5);
	//
	//		outputNeuron.calcOutput(FeedForwardNeuralNet.ActivationFunction.sigmoid);
	//
	//		Assert.assertEquals(FeedForwardNeuralNet.ActivationFunction.sigmoid.get(1), outputNeuron.getOutput(), 0);
	//	}
	//
	//	@Test
	//	public void testForNeuronWeightedSumWith3Inputs() {
	//
	//		FeedForwardNeuralNet.Neuron outputNeuron = new FeedForwardNeuralNet.Neuron();
	//
	//		outputNeuron.addConnection(new FeedForwardNeuralNet.Node(1), 0.5);
	//		outputNeuron.addConnection(new FeedForwardNeuralNet.Node(1), 0.5);
	//		outputNeuron.addConnection(new FeedForwardNeuralNet.Node(1), 0.5);
	//
	//		outputNeuron.calcOutput(FeedForwardNeuralNet.ActivationFunction.sigmoid);
	//
	//		Assert.assertEquals(FeedForwardNeuralNet.ActivationFunction.sigmoid.get(1.5), outputNeuron.getOutput(), 0);
	//
	//		//		Double truncatedDouble = BigDecimal.valueOf(toBeTruncated)
	//		//			    .setScale(3, RoundingMode.HALF_UP)
	//		//			    .doubleValue();
	//
	////		Assert.assertEquals(NeuralNet.ActivationFunction.sigmoid.get(0.59), n1.getOutput(), 0);
	//	}


}
