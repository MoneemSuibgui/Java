class TestGreetings{

    // entry pint to run our app
    public static void main(String[] args){


        // To use the greetings methods
    	// create a variable of type Greetings
        //  instantiating a new Greetings object (this is called dependency injection )
        Greetings greeterApp = new Greetings();

        // now we could access to Greetings class methods with greeterApp object
        // Use the variable to access Greetings methods
    	// using dot notation.
        String dateMessage=greeterApp.getCurrentDate();
        String greetMessageEnglish=greeterApp.greetEnglish("Maickel");
        String greetMessageSpanich=greeterApp.greetSpanish("Messi");


        System.out.println(dateMessage);
        System.out.println(greetMessageEnglish);
        System.out.println(greetMessageSpanich);

    }
}