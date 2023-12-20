public class TestOrder{
    public static void main(String[] args){


        CoffeKiosk CoffeKiosk1= new CoffeKiosk();
        CoffeKiosk1.addMenuItem("banana",2.00);
        CoffeKiosk1.addMenuItem("coffe",1.50);
        CoffeKiosk1.addMenuItem("latte",4.50);
        CoffeKiosk1.addMenuItem("muffin",4.00);

        CoffeKiosk1.newOrder();







        // System.out.println("------------Test getStatusMessage method-----------");
        
        // System.out.println(order1.getStatusMessage());
        // System.out.println(order3.getStatusMessage());


    }
}