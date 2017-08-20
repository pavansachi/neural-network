package com.net.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Neuron {

	private double output;

	public double getOutput() {
		return output;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		for (Connection conn: connections) {
			
			builder.append(conn);
		}
		
		return builder.toString();
	}

	private List<Connection> connections = new ArrayList<>();

	public List<Connection> getConnections() {
		return connections;
	}

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
	
	public void calcOutput(final Function<Double, Double> activation) {
		
		double sum = 0;

		for (Connection conn: connections) {

			double weight = conn.getWeight();

			double input = 0;
			
			// if inputs
			
			if (conn.getNode() != null) {
				
				input = conn.getNode().getInput();
			}
			
			if (conn.getNeuron() != null) {
				
				input = conn.getNeuron().output;
			}

			sum+= weight * input;
		}
		
		this.output = activation.apply(sum);
	}
}
