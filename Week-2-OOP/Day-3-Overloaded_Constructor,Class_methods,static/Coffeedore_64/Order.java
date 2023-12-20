import java.util.ArrayList;
public class Order{

    // Private Member Variables
    private String name;
    private boolean ready;
    private ArrayList<Item> items;


    
    

    // Constructor
    // Add a constructor to your Order class that takes no arguments, 
    //but sets the name to "Guest" 
    //and initializes the items array to an empty ArrayList<Item>
    public Order(){
        this.name="Guest";
        this.items= new ArrayList<Item>();
    }   
    // Overloaded Constructor
    // Add an overloaded constructor for Order that takes String name
    // as an argument, so you can create an instance with a name.
    public Order(String name){
        this.name=name;
        this.items=new ArrayList<Item>();
    }

    public void addItem(Item item){
        items.add(item);
    }


    public double getOrderTotal(){
        double total = 0;
        for(Item item : items){
            total += item.getPrice();
        }
        return total;
    }

    public void display(){
        System.out.println("Customer Name: "+this.name);
        for(Item item : items){
            System.out.println(item.getName()+" - $"+item.getPrice());
        }
        System.out.println("Total: $"+getOrderTotal());
    }



    // Create a method called getStatusMessage that returns a String message.
    // If the order is ready, return "Your order is ready.",
    // if not, return "Thank you for waiting. Your order will be ready soon."
    // getStatusMessage
    public String getStatusMessage(){
        if(this.isReady() == true){
            return"Your order is ready";
        }
        else{
            return "Thank you for waiting. Your order will be ready soon";
        }
    }




    // Getters & Setters
    // Create getters and setters for all the member variables,
    // using good naming convention for boolean accessors.
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }

    public boolean isReady(){
        return this.ready;
    }
    public void setIsReady(boolean ready){
        this.ready=ready;
    }

    public ArrayList getItems(){
        return this.items;
    }
    public void setItems(ArrayList items){
        this.items=items;
    }


    
}