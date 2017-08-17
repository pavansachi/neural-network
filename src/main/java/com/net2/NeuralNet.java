package com.net2;

import java.util.ArrayList;
import java.util.List;

import com.util.Function;

public abstract class NeuralNet {

	public NeuralLayer<Node> inputLayer = new NeuralLayer<Node>();
	public NeuralLayer<Neuron> outputLayer = new NeuralLayer<Neuron>();

	public static class ActivationFunction {

		public static Function sigmoid = v -> 1 / (1 + Math.exp(-v));

	}
	
	public static class Connection {

		private Node node;

		public Node getNode() {
			return node;
		}
		public void setNode(Node node) {
			this.node = node;
		}
		public Neuron getNeuron() {
			return neuron;
		}
		public void setNeuron(Neuron neuron) {
			this.neuron = neuron;
		}
		private Neuron neuron;

		private double weight;

		public double getWeight() {
			return weight;
		}
		public void setWeight(double weight) {
			this.weight = weight;
		}

	}

	public static class Neuron {

		private double output;

		public double getOutput() {
			return output;
		}

		@Override
		public String toString() {
			return "Neuron [output=" + output + "]";
		}

		private List<Connection> connections = new ArrayList<>();

		public void addConnection (Connection conn) {

			this.connections.add(conn);
		}
		
		public void addConnection (Node node, double w) {

			Connection conn = new Connection();
			conn.setWeight(w);
			conn.setNode(node);
			
			this.connections.add(conn);
		}
		
		public void addConnection (double w, Neuron neuron) {

			Connection conn = new Connection();
			conn.setWeight(0.5);
			conn.setNeuron(neuron);
			
			this.connections.add(conn);
		}
		
		public void calcOutput(final Function activation) {
			
			double sum = 0;

			for (Connection conn: connections) {

				double weight = conn.getWeight();

				double input = 0;
				
				// if inputs
				
				if (conn.getNode() != null) {
					
					input = conn.getNode().input;
				}
				
				if (conn.getNeuron() != null) {
					
					input = conn.getNeuron().output;
				}

				sum+= weight * input;
			}

			this.output = activation.get(sum);
		}
	}

	public static class Node {

		private double input;

		public void setInput(double input) {
			this.input = input;
		}

		public Node() {
		}
		
		public Node(double input) {
			this.input = input;
		}
		
	}

	public static class NeuralLayer<T> {

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

						neuron.addConnection(node, 0.5);
					}

				}

				if (!neurons.isEmpty()) {



				}

			}

		}

	}

}
