// package com.caresoft.clinicapp;

public class User {

	// Member Variables
	protected Integer id;
	protected int pin;
	
	// Constructor
	public User(Integer id) {
		this.id = id;
	}
	
	// Getters & Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}

	
}
