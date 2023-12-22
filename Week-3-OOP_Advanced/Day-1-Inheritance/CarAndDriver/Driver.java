
public class Driver extends Car{


		// Constructor
		public Driver(int gaz) {
			super(gaz);
		}
	

	// Drive method
	public void drive() {
		// Driving should decrease gas by 1
		setGaz(getGaz()-1);
		System.out.println("You drive the car ");
		// invoke status method from the parent class
		status();
	}
	
	//  Boost method
	public void boost() {
		
		if(getGaz()>3) {
//			Refueling should increase gas by 2
			setGaz(getGaz()-2);
			System.out.println("You are using the boosters !!");
			// invoke status method from the parent class
			status();
		}else {
			System.out.println("Gaz remaining less than 3 you cannot boost !!!");
		}
	}
	
	//  Refuel method
	public void refuel() {
		if(getGaz()<8) {
			// Refueling should increase gas by 2
			setGaz(getGaz()+2);
			System.out.println("You  refuel the car");
			status();
		}
		else{
			System.out.println("Gaz remaining more than 8 you cannot refuel your car !!! ");
		}
	}
}
