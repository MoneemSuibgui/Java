
public class Item{

    // Private Member Variables
    private String name;
    private double price;
    private int index;

    // Constructor
    public Item(String name,double price){
        this.name=name;
        this.price=price;
    }


    // Getters & Setters 
    public String getName(){
        return this.name;
    }
    public void setName(String newName){
        this.name=newName;
    }

    public double getPrice(){
        return this.price;
    }
    public void setPrice(double newPrice){
        this.price=newPrice;
    }

    
    public int getIndex(){
        return this.index;
    }
    public void setIndex(int newIndex){
        this.index=newIndex;
    }

}