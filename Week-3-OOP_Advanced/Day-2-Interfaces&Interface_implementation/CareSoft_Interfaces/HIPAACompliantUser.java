// package com.caresoft.clinicapp;

public interface HIPAACompliantUser {
	
	// we must use those abstract methods when we implements interface into the class
	abstract boolean assignPin(int pin);
	abstract boolean accessAuthorized(Integer confirmedAuthID);
	
}
