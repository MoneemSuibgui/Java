import java.util.Date;

public class AlfredQuotes {
    
    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        //  using the String.format method 
        String myGestGreeting = String.format("Hello ,%s .Lovely to see you",name);
        return myGestGreeting ;
    }

    // Overloaded guestGreeting method same method name & # method sighnature(parameter types)
    public String guestGreeting(String name,String dayPeriod) {
        return String.format("Good %s ,%s .Lovely to see you",dayPeriod,name);
    }

    // yellsAlert() method he somtimes yell's when he angry
        public String yellsAlert(String name) {
        return String.format("%s ,i am hungry !!!" ,name);
    }
    
    public String dateAnnouncement() {
        // Implement the dateAnnouncement method
        Date date = new Date();
        String dateMassage ="it is currently "+date+".";
        // another way to concatenate strings
        return dateMassage;
    }
    
    public String respondBeforeAlexis(String conversation) {
        String alexisName="Alexis";
        String alfredName="Alfred";

        //using .contains() method 
        /*
        if(conversation.contains(alexisName )){
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        }
        else if(conversation.contains(alfredName)){
            return "At your service. As you wish, naturally.";
        }
        else{
            return "Right. And with that I shall retire.";
        }
        */


        //  using indexOf method()
        if(conversation.indexOf(alexisName ) != -1){
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        }
        else if(conversation.indexOf(alfredName) != -1){
            return "At your service. As you wish, naturally.";
        }
        else{
            return "Right. And with that I shall retire.";
        }

        
    }
    
	// NINJA BONUS
	// See the specs to overload the guestGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

