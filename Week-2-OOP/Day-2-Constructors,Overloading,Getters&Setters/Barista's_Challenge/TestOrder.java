public class TestOrder{
    public static void main(String[] args){

        // Create 2 orders for unspecified guests (without specifying a name)
        Order order1 =new Order();
        Order order2 =new Order();

        // Create 3 orders using the overloaded constructor to give each a name for the order.
        Order order3 =new Order("Cindhuri");
        Order order4 =new Order("Moneem");
        Order order5 =new Order("Sam");


        // create our items (instantiate objects from the class Item)
        Item item1 =new Item("cupuccino",3.50);
        Item item2=new Item("drip coffe",1.50);
        Item item3=new Item("latte",2.45);



        // Add at least 2 items to each of the orders using the addItem method
        order1.addItem(item1);
        order1.addItem(item2);
        order1.addItem(item3);

        order2.addItem(item1);
        order2.addItem(item2);
        order2.addItem(item3);

        order3.addItem(item2);
        order3.addItem(item3);

        order4.addItem(item1);
        order4.addItem(item2);

        order5.addItem(item1);
        order5.addItem(item3);
        
        System.out.println("------------Test display method-----------");
        order3.display();
        
        // test the initial value of ready using isReady method 
        System.out.println("-------------test the initial value ready---------");

        System.out.println(order1.getStatusMessage());
        System.out.println(order3.getStatusMessage());

        //setIsReady method
        order1.setIsReady(true);
        order3.setIsReady(true);

        
        

        System.out.println("------------Test getStatusMessage method-----------");
        
        System.out.println(order1.getStatusMessage());
        System.out.println(order3.getStatusMessage());

        System.out.println("---------Test getOrderTotal method--------");
        System.out.println(order3.getOrderTotal());

    }
}