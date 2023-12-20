public class TestPerson{
    public static void main(String[] args){

    // create 3 instance of Person class
    Person person1= new Person("Moneem",32);
    Person person2=new Person("Tina",22);

    // access to the number of person as public variables in the class Person
    // System.out.println(" The number of person is :"+Person.numberOfPerson);

    // access to the number of person as public variables in the class Person
    // we should have getter and setter method to access to it
    // System.out.println(Person.numberOfPerson); //  error: numberOfPerson has private access in Person

    System.out.println(Person.getNumberOfPerson());

    System.out.printf("The id of %s is : %s \n",person1.getName(),person1.getID());
    System.out.printf("The id of %s is : %s",person2.getName(),person2.getID());
    }
}