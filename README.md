# neural-network
A generic neural network training implementation

## Language
Java  
Nodejs

### Usage

NeuralNetwork network = new NeuralNetwork.Builder()  
   .inputs(2)  
   .hidden(3)  
				.output(1, ActivationFunction.SIGMOID)  
				.activation(ActivationFunction.SIGMOID)  
				.build();  

#### Train the network

epoch is a single iteration for one training input.  
 
@param INPUTS, a list of inputs  
@param epochCount, number of iterations of training    
network.train(INPUTS, epoch);  



