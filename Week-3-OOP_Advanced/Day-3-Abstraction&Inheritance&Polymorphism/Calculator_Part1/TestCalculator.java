// package com.calculator1.moneem;

public class TestCalculator {

	public static void main(String[] args) {
	
		// create calculator
		Calculator calculator =new Calculator();
		
		
		calculator.setOperandOne(10.5);
		calculator.setOperandTow(5.2);
		calculator.setOperation("+");
		calculator.performOperation();
		calculator.getResult();
	}

}
