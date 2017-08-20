package com.net;

import com.net.model.NeuralLayer;
import com.net.model.Neuron;
import com.net.model.Node;

public abstract class AbstractNeuralNet implements INeuralNet {

	public NeuralLayer<Node> inputLayer = new NeuralLayer<Node>(NeuralLayer.INPUT_LAYER);
	public NeuralLayer<Neuron> outputLayer = new NeuralLayer<Neuron>(NeuralLayer.OUTPUT_LAYER);

	public void addNodes (NeuralLayer<Node> layer, int count) {

		for (int i=0; i< count; i++) {

			layer.addNode(new Node());
		}
	}

	public void addNeurons (NeuralLayer<Neuron> layer, int count) {

		for (int i=0; i< count; i++) {

			layer.addNeuron(new Neuron());
		}
	}
	
	@Override
	public void printModel() {
		
		System.out.println(outputLayer);
	}

	public abstract double calcOutput(double[] inputs);
	public abstract double calcError(double realoutput, double calcOutput);
	public abstract void adjustWeights(double error);

}