// package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser,HIPAACompliantAdmin  {

    // Member Variables
	private String role;
    private ArrayList<String> securityIncidents=new ArrayList<String>();
    
	

	// AdminUser Constructor
	public AdminUser(Integer id,String role) {
		super(id);
		this.role=role;
	}
		
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// Returns a list of strings (incidents reported)
        // Implement HIPAACompliantAdmin!
		return this.securityIncidents;
	}


    // TO DO: Implement HIPAACompliantUser!
	@Override
	public boolean assignPin(int pin) {
		// Pin must be 6 digits or more; returns false if not
		int digitNum=String.valueOf(pin).length();
		if(digitNum >= 6) {
			return true;
		}
		return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(confirmedAuthID.equals(id)) {
			return true;
		}
		// if they are not a match, creates an incident report using the authIncident method,
		authIncident();
		return false;
	}

    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    
    // authIncident method create new report and add to the securityIncidents arrayList when accessAuthorized method failed
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        this.securityIncidents.add(report);
    }
    
    // Getters &Setters
    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
    
    


}
