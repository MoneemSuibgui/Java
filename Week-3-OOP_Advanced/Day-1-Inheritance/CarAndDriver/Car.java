
public class Car {
	// Member Variables
	protected int gaz;

	// Car Constructor 
	public Car(int gaz) {
		this.gaz = gaz;
	}

	// status method
	public void status() {
		System.out.println("Gaz remaining : "+this.gaz+"/10");
		 // Add a 'game over' message when the gas reaches zero.
		if(this.gaz == 0) {
			System.out.println(" game over !!!");
		}
	}
	
	
	
	// Getters And Setters
	public int getGaz() {
		return gaz;
	}

	public void setGaz(int gaz) {
		this.gaz = gaz;
	}
	
	
	

}
