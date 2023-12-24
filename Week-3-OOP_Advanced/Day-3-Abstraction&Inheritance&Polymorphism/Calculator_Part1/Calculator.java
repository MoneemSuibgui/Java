// package com.calculator1.moneem;

public class Calculator {
	// member variables 
	private double OperandOne;
	private double OperandTow;
	private String Operation;
	
	// Bean Constructor(empty)
	public Calculator() {
	}
	
	// performOperation method
	public double performOperation() {
		double result=0;
		if(this.getOperation().equals("+")) {
			result=this.getOperandOne()+this.getOperandTow();
			return result;
		}else if(this.getOperation().equals("-")) {
			result= this.getOperandOne()-this.getOperandTow();
			return result;
		}
		else {
			System.out.println("Please enter the right input !!! ");
			return result;
		}
	}
	
	// getResult method
	public void getResult() {
		System.out.println("the result wold be "+this.performOperation());
	}
	
	
	// getters and setters
	public double getOperandOne() {
		return OperandOne;
	}
	public void setOperandOne(double operandOne) {
		OperandOne = operandOne;
	}
	public double getOperandTow() {
		return OperandTow;
	}
	public void setOperandTow(double operandTow) {
		OperandTow = operandTow;
	}
	public String getOperation() {
		return Operation;
	}
	public void setOperation(String operation) {
		Operation = operation;
	}

	
	

}
