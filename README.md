# neural-network
A generic neural network training implementation

## Language
Java  
Nodejs

### Usage

NeuralNetwork network = new NeuralNetwork.Builder()  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.inputs(2)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.hidden(3)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.output(1, ActivationFunction.SIGMOID)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.activation(ActivationFunction.SIGMOID)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.build();  

#### Train the network

epoch is a single iteration for one training input.  
 
@param INPUTS, a list of inputs  
@param epochCount, number of iterations of training    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;network.train(INPUTS, epoch);  



