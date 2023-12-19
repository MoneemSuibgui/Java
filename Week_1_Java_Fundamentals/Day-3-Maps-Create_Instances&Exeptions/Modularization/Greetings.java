// importing the Date class
import java.util.Date;
class Greetings{

    
    // create 3 methods
    public String getCurrentDate(){
        // we have to import the Date class to used
        // instantiante our date
        Date date = new Date();
        return "The  current date is : " + date;
    }

    public String greetEnglish(String name) {
        return "Hello, " + name;
        
    }
    public String greetSpanish(String name) {
        return "Hola, " + name;
        
    }
}