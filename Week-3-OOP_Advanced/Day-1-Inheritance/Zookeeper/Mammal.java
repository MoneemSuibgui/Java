
public class Mammal {
	
	// Empty Mammal Constructor
	public Mammal() {
	}
	
	// Mammal Constructor with energyLevel passing as parameter 
	public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
	}

	// Member Variables
	//  Every mammal should have an energy level (default 100)
	private int energyLevel=100;
	
	// displayEnergy method
	public String displayEnergy() {
		String message= String.format("Energy level is :%s",this.energyLevel); 
	    return message;
	}
	
	// getters & setters
	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

	
	

}
