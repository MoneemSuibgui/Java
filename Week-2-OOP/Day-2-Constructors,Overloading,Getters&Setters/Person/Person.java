public class Person {
    // Member variables
    private String name;
    private int age;

    private int ID;

    // static variables it's belong to the class not to the object
    // public static int numberOfPerson=0;
    // static variables are creating class variables those are shared across all objects. 
    // the variable is now private
    private static int numberOfPerson=0;



    // Constructor
    public Person(String newName,int newAge){
        System.out.println(" Create new person ");
        this.name=newName;
        this.age=newAge;
        numberOfPerson++;
        this.ID=numberOfPerson;
    }


    // Getters And Setters Methods
    public String getName(){
        return this.name;
    }
    public void setName(String anotherName){
        this.name=anotherName;
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int anotherAge){
        this.age=anotherAge;
    }

    //  getNumberOfPerson it belongs only to the class 
    //  class methods cannot access instance variables or instance methods directly.
    //  In addition, class methods cannot use the this keyword as there is no instance for this to refer to.
    public static int getNumberOfPerson(){
        return numberOfPerson;
    }

    public int getID(){
        return this.ID;
    }


}