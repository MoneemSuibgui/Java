

public class CarAndDriver {

	public static void main(String[] args) {
		
		// instantiate the driver class
		Driver driver = new Driver(4);
		
		driver.drive();
		driver.drive();
		driver.drive();
		driver.drive();
		System.out.println("--------------");
		
		driver.boost();
		System.out.println("---------------");
		
		driver.refuel();
		driver.refuel();
		driver.refuel();

	}

}
