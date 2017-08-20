package com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.net.NetworkException;
import com.net.impl.NeuralNetwork;
import com.net.model.Neuron;
import com.net.model.Node;
import com.util.MathFunction;

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
				.activationFunction(MathFunction.step)
				.learningRate(0.02)
				.iterations(100)
				.build();

		orNetWork.train(new double[][] {
			{0, 0},
			{0, 1},
			{1, 0},
			{1, 1}
		}, new double[][] {
			{0},
			{1},
			{1},
			{1}
		});

		double[] output = orNetWork.predict(new double[] {
				1, 0
		});

		Assert.assertEquals(1, output[0], 0);

	}

	@Test
	public void testPredictingANDOutput() throws NetworkException {

		NeuralNetwork andNetWork = new NeuralNetwork.Builder()
				.inputs(2)
				.outputs(1)
				.activationFunction(MathFunction.step)
				.learningRate(0.02)
				.iterations(100)
				.build();

		andNetWork.train(new double[][] {
			{0, 0},
			{0, 1},
			{1, 0},
			{1, 1}
		}, new double[][] {
			{0},
			{0},
			{0},
			{1}
		});

		double[] output = andNetWork.predict(new double[] {
				1, 0
		});

		Assert.assertEquals(0, output[0], 0);

	}
	
	@Ignore
	public void testPredictingIrisDataWith2ClassesOutput() throws NetworkException, FileNotFoundException, IOException {

		NeuralNetwork net = new NeuralNetwork.Builder()
				.inputs(4)
				.outputs(1)
				.activationFunction(MathFunction.step)
				.learningRate(0.02)
				.iterations(10000)
				.build();

		double[][] inputs = new double[100][4];
		double[][] outputs = new double[100][1];

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

				double oVal = Double.valueOf(data[4]);
				
				double[] output = { 
					Double.valueOf(data[4]) 
				};

				if (oVal == 0 || oVal == 1) {

					inputs[idx] = input;
					outputs[idx] = output;
				}

				idx++;
			}
		}

		net.train(inputs, outputs);

		double[] calcOutputs = net.predict(new double[] {
				//				5.1,3.5,1.4,0.2
				//				5.7,4.4,1.5,0.4
				//				6.8,2.8,4.8,1.4
				//				5.0,3.2,1.2,0.2
				//				6.7,3.1,4.4,1.4
				4.7,3.2,1.6,0.2
		});

		Assert.assertEquals(0, calcOutputs[0], 0);

	}

	@Test
	public void testPredictingRandomTestOutput() throws NetworkException {

		NeuralNetwork orNetWork = new NeuralNetwork.Builder()
				.inputs(2)
				.outputs(1)
				.activationFunction(MathFunction.step)
				.learningRate(0.02)
				.iterations(100)
				.build();

		orNetWork.train(new double[][] {
			{1, 0},
			{1, 1},
		}, new double[][] {
			{1},
			{1},
		});

		double[] output = orNetWork.predict(new double[] {
				1, 1
		});

		Assert.assertEquals(1, output[0], 0);

	}

	@Test
	public void testForNeuronWeightedSumWith2Inputs() {

		Neuron outputNeuron = new Neuron();

		outputNeuron.addConnection(new Node(1), 0.6);
		outputNeuron.addConnection(new Node(1), 0.6);

		outputNeuron.calcOutput(MathFunction.step);

		Assert.assertEquals(1.0, outputNeuron.getOutput(), 0);
	}

	@Test
	public void testForNeuronWeightedSumWith3Inputs() {

		Neuron outputNeuron = new Neuron();

		outputNeuron.addConnection(new Node(1), 0.5);
		outputNeuron.addConnection(new Node(1), 0.5);
		outputNeuron.addConnection(new Node(1), 0.5);

		outputNeuron.calcOutput(MathFunction.step);

		Assert.assertEquals(1, outputNeuron.getOutput(), 0);

		//		Double truncatedDouble = BigDecimal.valueOf(toBeTruncated)
		//			    .setScale(3, RoundingMode.HALF_UP)
		//			    .doubleValue();

		//		Assert.assertEquals(NeuralNet.ActivationFunction.sigmoid.get(0.59), n1.getOutput(), 0);
	}


}
