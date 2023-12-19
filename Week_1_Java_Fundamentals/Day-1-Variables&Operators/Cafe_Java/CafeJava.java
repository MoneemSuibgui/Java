public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = " Your total is $";
        
        // Menu price  variables (add yours below)
        double mochaPrice = 3.5;
        // 1- Create 3 more drink price variables, for drip coffee, 
        // latte and cappucino following the same camel case naming convention.
        double dripCoffee= 4.3;
        double latteCoffe= 2.5 ;
        double cappucinoCoffe=5.2;


        // Drinks list
        String coffe1=" mocchaCoffe";
        String coffe2=" dripCoffee";
        String coffe3=" latteCoffe";
        String coffe4=" cappucinoCoffe";



    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";

        // 2- Create 3 more customer variables for Sam, Jimmy and Noah, 
        //following the same variable naming convention in the example.
        String customer2= "Sam";
        String customer3= "Jimmy";
        String customer4= "Noah";
        
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;

        // 3- Create the order status flag (true/false) for each customer, 
        // following the variable naming convention in the example.
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;

        
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"

        //4-  Print to the console the correct status message, based on her order status.
        System.out.println(customer1+pendingMessage);

        //5- Noah ordered a cappucino. Use an if statement to check the status of his order and
        // print the correct status message. If it is ready, also print the message
        // to display the total.
        // Note: Outcomes may be different depending on what you assigned as the status.
        System.out.println(customer4 +coffe4);
        System.out.println("===============");
        
        //using ternory operators
        System.out.println(isReadyOrder4? customer4 + readyMessage + displayTotalMessage + cappucinoCoffe 
                            :pendingMessage );
        
        System.out.println("===============");
        // using if statments 
        if(isReadyOrder4){
            System.out.println(customer4+readyMessage+displayTotalMessage+cappucinoCoffe);
        }
        else{
            System.out.println(customer4+pendingMessage);
        }

        System.out.println("===============");
        //6- Sam just ordered 2 lattes, print the message to display their total. 
        System.out.println(customer2 + displayTotalMessage +( 2*latteCoffe));
        // Next, use an if statement to print the appropriate order status message.
        // Change the isReady flag value from true to false or vice versa in order to test your control logic (if-statement).
        System.out.println("===============");
        if(isReadyOrder2){
            System.out.println(customer2+readyMessage);
        }
        else{
            System.out.println(customer2+pendingMessage);
        }
        

        //7- Jimmy just realized he was charged for a coffee but had ordered a latte. Print the total message with the new calculated total (what he owes) to make up the difference.
        System.out.println("===============");
        System.out.println(customer3 + " to make up the difference " + displayTotalMessage +(dripCoffee-latteCoffe));


    	// ** Your customer interaction print statements will go here ** //
    }
}


/*
1/ Create 3 more drink price variables, for drip coffee, latte and cappucino following the same camel case naming convention.

2/ Create 3 more customer variables for Sam, Jimmy and Noah, following the same variable naming convention in the example.

3/ Create the order status flag (true/false) for each customer, following the variable naming convention in the example.

4/ For the next tasks, we will be simulating customer interactions, printing messages to the screen, based on scenarios. Cindhuri ordered a coffee. Print to the console the correct status message, based on her order status.

5/ Noah ordered a cappucino. Use an if statement to check the status of his order and print the correct status message. If it is ready, also print the message to display the total. Note: Outcomes may be different depending on what you assigned as the status.

6/ Sam just ordered 2 lattes, print the message to display their total. Next, use an if statement to print the appropriate order status message. Change the isReady flag value from true to false or vice versa in order to test your control logic (if-statement).

7/ Jimmy just realized he was charged for a coffee but had ordered a latte. Print the total message with the new calculated total (what he owes) to make up the difference.

8/Try changing the price values for each drink and isReady flags (booleans), to test if all of your logic works, even when prices and statuses are changed.
*/