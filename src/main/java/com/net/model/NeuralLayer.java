package com.net.model;

import java.util.ArrayList;
import java.util.List;

import com.util.MathFunction;

/**
 * Neural layer
 * @author pavansachi
 *
 * @param <T>
 */
public class NeuralLayer<T> {

	public static final String INPUT_LAYER = "Input Layer";
	public static final String OUTPUT_LAYER = "Output Layer";
	
	public NeuralLayer() {

	}

	public NeuralLayer(String type) {

		this.type = type;
	}

	private String type;
	
	private List<Node> nodes = new ArrayList<>();

	public List<Node> getNodes() {
		return nodes;
	}

	public void addNode(Node child) {

		this.nodes.add(child);
	}

	private List<Neuron> neurons = new ArrayList<>();

	public List<Neuron> getNeurons() {
		return neurons;
	}

	public void addNeuron(Neuron child) {

		this.neurons.add(child);
	}

	public void connect (NeuralLayer<Neuron> layer) {

		for (Neuron neuron: layer.neurons) {

			if (!nodes.isEmpty()) {

				for (Node node: this.nodes) {

					neuron.addConnection(node, MathFunction.random());
				}

			}

			if (!neurons.isEmpty()) {



			}

		}

	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append(this.type)
		.append("\n")
		.append("Number of ");
		
		if (this.type.equals(NeuralLayer.INPUT_LAYER)) {
			builder.append("nodes = ");
			builder.append(nodes.size());
			builder.append("\n");
			
			builder.append(nodes);
		}
		
		if (this.type.equals(NeuralLayer.OUTPUT_LAYER)) {
			builder.append("neurons = ");
			builder.append(neurons.size());
			builder.append("\n");
			
			builder.append(neurons);
		}
		
		return builder.toString();
	}

}