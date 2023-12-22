
public class Gorilla extends Mammal {
	

	// Gorilla able to throw things at people will lose energy (-5) 
	public void throwSomething() {
		setEnergyLevel(getEnergyLevel()-5);
		System.out.println("the gorilla has thrown something, as well as decrease the energy level by 5 \n Energy Level :"+ displayEnergy());
	}
	// The gorilla able to eatBananas and regain energy (+10). 
	public void eatBanans() {
		setEnergyLevel(getEnergyLevel()+10);
		System.out.println("the gorilla eat banana and increase its energy by 10 \n " +displayEnergy());
	}
	// the Gorilla  able to climb at the expense of energy (-10).
	public void climb() {
		setEnergyLevel(getEnergyLevel()-10);
		System.out.println("the gorilla has climbed a tree and decrease its energy by 10 \n " +displayEnergy());

		
	}
}
