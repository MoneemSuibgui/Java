import java.util.ArrayList;
import java.util.Arrays;
public class TestCafe {
    public static void main(String[] args) {
        
        
        // create an instance of the CafeUtil class.
        CafeUtil appTest =new CafeUtil();

        /* ============ App Test Cases ============= */
    
        System.out.println("----- Streak Goal Test -----");
        System.out.printf("Purchases needed by  10 weeks : %d \n\n", appTest.getStreakGoal());

        System.out.printf("Purchases needed by a given number of weeks : %d \n\n", appTest.getStreakGoal(17));

    
        System.out.println("----- Order Total Test-----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %.2f \n\n",appTest.getOrderTotal(lineItems));
        
        System.out.println("----- Display Menu Test-----");
        
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        
    
        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        for (int i = 0; i < 4; i++) {
            appTest.addCustomer(customers);
            System.out.println("\n");
        }

        appTest.printPriceChart("Columbian Coffe Grounds",2.5,3);

        // create arrayList for price of each product & test the oveloaded displayMenu method
        ArrayList<Double> prices = new ArrayList<Double>();
        prices.add(2.5);
        prices.add(4.9);
        prices.add(5.3);
        prices.add(3.5);

        appTest.displayMenu(menu,prices);
    }    
}