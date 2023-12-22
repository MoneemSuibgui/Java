public class Bat extends Mammal {

	
	//  Bat Constructor inherit energyLevel from Mammal and its energy level is 300.
	public Bat() {
		super(300);
	}
	
	// fly method
	public void fly() {
		String sound="zzzz";
		setEnergyLevel(getEnergyLevel()-50);
		System.out.println("the  bat fly and the  sound of a bat taking off is :"+sound+"\n"+displayEnergy());
		
		
	}
	// eatHuman method
	public void eatHuman() {
		setEnergyLevel(getEnergyLevel()+25);
		System.out.println("the Bat eat human \n"+displayEnergy());
		
	}
	// attackTown method
	public void attackTown() {
		String sound="oofffff";
		setEnergyLevel(getEnergyLevel()-100);
		System.out.println("The bat attack town and the sound off is :"+sound+"\n"+displayEnergy());	
	}
	
	
}
