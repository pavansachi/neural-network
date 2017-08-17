package com.net2;

import java.util.Iterator;

import com.util.Function;

public class FeedForwardNeuralNet extends NeuralNet implements INeuralNet {

	public static class ActivationFunction {

		public static Function sigmoid = v -> 1 / (1 + Math.exp(-v));

	}
	
	public FeedForwardNeuralNet(int inputs, int outputs) {

		for (int i=0; i< inputs; i++) {

			inputLayer.addNode(new Node());
		}

		for (int i=0; i< outputs; i++) {

			outputLayer.addNeuron(new Neuron());
		}

		inputLayer.connect(outputLayer);
		
	}
	
	@Override
	public void train (double[] inputs, double[] outputs) {
		
		Iterator<Node> iterator = inputLayer.getNodes().iterator();
		
		for (double input: inputs) {
			
			Node node = iterator.next();
			node.setInput(input);
		}

		// output layer
		for (Neuron neuron: outputLayer.getNeurons()) {
			
			neuron.calcOutput(ActivationFunction.sigmoid);
			
		}
		
		System.out.println(outputLayer);
	}


}
