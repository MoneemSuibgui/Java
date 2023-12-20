import java.util.ArrayList;
public class CoffeKiosk{

    // Member variables
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;


    // Constructor
    // Constructor - no params, initializes items and orders to empty arrays.
    public CoffeKiosk(){
        this.menu=new ArrayList<Item>();
        this.orders= new ArrayList<Order>();
    }

    // addMenuItem method
    public void addMenuItem(String name,double price){

        Item item=new Item(name,price);
        menu.add(item);
        int newMenuIndex = menu.indexOf(item);
        item.setIndex(newMenuIndex);
    }

    // displayMenu
    public void displayMenu(){
        for(Item item :menu){
            System.out.println(item.getIndex()+" "+item.getName()+" -- $"+item.getPrice());
        }
    }

        public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
    	// Your code:
        // Create a new order with the given input string
        Order order1 =new Order(name);
        // Show the user the menu, so they can choose items to add.
        displayMenu();
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            
            // Get the item object from the menu, and add the item to the order
            try{
                order1.addItem(menu.get(Integer.parseInt(itemNumber)));
            }catch(IndexOutOfBoundsException i){
                System.out.println("Invalid selection");
            }catch(NumberFormatException n){
                System.out.println("Invalid selection");
            }
            // Ask them to enter a new item index or q again, and take their input
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();
            
        }
            
            // Get the item object from the menu, and add the item to the order
            // Ask them to enter a new item index or q again, and take their input
        order1.display();
        // After you have collected their order, print the order details 
    	// as the example below. You may use the order's display method.
        
    }
}

