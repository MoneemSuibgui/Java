
public class TestOrders{
    public static void main(String[] args){

        // instantiate our objects from classes

        // Create 4 order variables of type Order and instantiate each as an Order object.
        // Name them order1, order2 etc.
        Order  order1 = new Order();
        Order  order2 = new Order();
        Order  order3 = new Order();
        Order  order4 = new Order();

        // Set each order's name -- "Cindhuri", "Jimmy", "Noah", "Sam".
        order1.name="Cindhuri";
        order2.name="Jimmy";
        order3.name="Noah";
        order4.name="Sam";

        // Create 4 item variables of type Item and instantiate each as an Item object.
        // Name them item1, item2 etc.
        Item  item1 = new Item();
        Item  item2 = new Item();
        Item  item3 = new Item();
        Item  item4 = new Item();


        // Set the price and the name for each -- "mocha", "latte", "drip coffee" and "capuccino"
        // (price is up to you!)
        item1.name="mocha";
        item1.price= 4.0;

        item2.name="latte";
        item2.price = 1.5;

        item3.name="drip coffee";
        item3.price= 2.5;

        item4.name="capuccino";
        item4.price= 3.5;


        // Print the order1 variable to the console to see what happens.
        System.out.println(order1); //output in the terminal "Order@36baf30c"  Object name and her memory adress
        // Predict what will happen if you print order1.total
        System.out.println("Order 1 totaol is "+ order1.total +"\n\n"); // output in the terminal : 0.0 becouse total is double by default is 0.0
        
        // Add item1 to order2's item list and increment the order's total.
        order2.items.add(item1);
        order2.total++;
        

        //  order3 ordered a cappucino. Add the cappuccino to their order list and to their tab.
        order3.items.add(item4);
        order3.total+=item4.price;


        // order4 added a latte. Update accordingly.
        order4.items.add(item2);
        order4.total+=item2.price;



        // Cindhuri’s order is now ready. Update her status.
        order1.ready = true ;

        // Sam ordered more drinks - 2 lattes. Update their order as well.
        order4.items.add(item2);
        order4.items.add(item2);
        order4.total+=(item2.price *2);

        // Jimmy’s order is now ready. Update his status.
        order3.ready = true ;
        




        
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);

        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: %s\n", order2.total);
        System.out.printf("Ready: %s\n", order2.ready);

        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: %s\n", order3.total);
        System.out.printf("Ready: %s\n", order3.ready);

        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: %s\n", order3.total);
        System.out.printf("Ready: %s\n", order3.ready);
    


        }
}