//package com.net;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import com.util.Function;
//
//public class NeuralNet {
//
//	public static class Node {
//		
//		private double input;
//		
//		
//	}
//	
//	public static class Builder {
//
//		private int inputNodes;
//		private int hiddenNodes;
//		private int outputNodes;
//
//		public Builder hiddenNodes (int v) {
//
//			this.hiddenNodes = v;
//			return this;
//		}
//
//		public Builder inputNodes (int v) {
//
//			this.inputNodes = v;
//			return this;
//		}
//
//		public Builder outputNodes (int v) {
//
//			this.outputNodes = v;
//			return this;
//		}
//
//		public NeuralNet build() {
//
//			NeuralNet net = new NeuralNet(inputNodes, hiddenNodes, outputNodes);
//
//			return net;
//		}
//	}
//
//
//}
