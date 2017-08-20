package com.net.model;

import java.util.Map;

public class NeuralModel {

	private Map<String, NeuralLayer<Neuron>> model;

	public Map<String, NeuralLayer<Neuron>> getModel() {
		return model;
	}

}
