// package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
    private ArrayList<String> patientNotes;

	// Physician constructor that takes an ID inherited from User super class
	public Physician(Integer id) {
		super(id);
	}
    
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
    // TO DO: Setters & Getters


	@Override
	public boolean assignPin(int pin) {
		// 	Pin must be exactly 4 digits, returns false if not.
		// Expected to assign the pin to the user (as a member variable)
		
		int numDigits = String.valueOf(pin).length();
		if(numDigits == 4) {
			return true;
		}
		return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// Checks the physician's id against the given id;
		//returns true if they are a match, otherwise false.
		if(confirmedAuthID.equals(id)) {
			return true;
		}
		return false;
	}



	// Getters & Setters
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	

}
