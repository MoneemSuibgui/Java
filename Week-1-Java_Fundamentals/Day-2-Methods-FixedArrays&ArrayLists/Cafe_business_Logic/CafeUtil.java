import java.util.ArrayList;
class CafeUtil{

// getSteakGoal method : calculate  how many drinks of custumoers they need after 10 weeks (hard coded )
    public int getStreakGoal(){
        int sum = 0;
        for(int i=1 ;i<11;i++){
            sum+=i;
        }
        return sum;
    }

    // Overloaded  getSteakGoal method : calculate  how many drinks of custumoers they need after a given number of weeks
    public int getStreakGoal(Integer numWeeks){
        int sum = 0;
        for(int i=1 ;i<=numWeeks;i++){
            sum+=i;
        }
        return sum;
    }

// displayMenu method: Given an ArrayList of menu items (strings) & print out each index and menu item
    public static void displayMenu(ArrayList<String> menuList){
        for(int i=0; i<menuList.size();i++){
            System.out.println(i +" "+ menuList.get(i));
        }
    }

// getOrderTotalmethod : given an array of item prices from an order, sum all of the prices in the array and return the total.
// other way for looping ang get the sum of items using Enhanced for loop 
    public double getOrderTotal(double[] prices){
        double sum=0;
        for(double price :prices){
            sum+=price;
        }
        return sum;
    }

// addCustomer method 
    public static void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name : ");

        //  get user input from the terminal and store it in the variable userName
        String userName = System.console().readLine();
        //  print the userName to the console
        System.out.println(String.format("Hello, %s! There are %d people ahead of you.",userName,customers.size()));
        //  add the customer's name to the given customers list
        customers.add(userName);
        for(int i=0 ;i<customers.size();i++){
            System.out.print(String.format("[%s]",customers.get(i)));
        }
    }

    //  printPriceChart method
    public void printPriceChart(String product, double price, int maxQuantity){
        System.out.println(product);
        for(int i=1;i<=maxQuantity;i++){
            System.out.println(String.format("%d - $ %.2f",i,price*i));
        }
    }


    //  Overloading displayMenu method
    public  boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices){
        // check the size of the arrays are te same size or not
        boolean checkArraySizes=false;

        if(menuItems.size() != prices.size()){
            return checkArraySizes;
        }
        else{
            for(int i=0;i<menuItems.size() && i<prices.size() ;i++){
                    System.out.println(String.format("%d %s -- $ %.2f ",i, menuItems.get(i),prices.get(i)));
            }
        }
        return !checkArraySizes;

    }
}


