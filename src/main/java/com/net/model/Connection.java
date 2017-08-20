package com.net.model;

public class Connection {

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("weight = ");
		builder.append(weight);
		builder.append("\n");
		
		return builder.toString();
	}
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
