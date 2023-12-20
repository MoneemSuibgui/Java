public class VehiculeTest{
    public static void main(String[] args) {

        // instatiate our objects 
        Vehicule bike =new Vehicule();
        Vehicule car = new Vehicule();

        // set our instance variables
        bike.setNumberOfWhells(2);
        bike.setColor("black");

        car.setNumberOfWhells(4);
        car.setColor("grey");

        // retrieve our member variables instance
        int bikeWheels=bike.getNumberOfWheels();
        String bikeColor=bike.getColor();

        int carWheels=car.getNumberOfWheels();
        String carColor=car.getColor();

        System.out.println("Bike object - Wheels: " + bikeWheels + ", Color: " + bikeColor);
        System.out.println("Car object - Wheels: " + carWheels + ", Color: " + carColor);

    }
}