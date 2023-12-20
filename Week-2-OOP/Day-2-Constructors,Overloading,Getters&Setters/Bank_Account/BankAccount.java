import java.util.Random;
public class BankAccount{

    

    // Member variables
    private double  checkingBalance;
    private double savingsBalance;
    // optional :add an id to each bank account
    private int ID ; // by default id=0
    


    // Member class variable
    private static int numberOfAccounts=0;
    private static double totalAmountStored;
    private static int randomAccountNumber;

    // Constructor
    public BankAccount(){
        this.checkingBalance=0;
        this.savingsBalance=0;
        numberOfAccounts++;
        totalAmountStored+=(this.savingsBalance + this.checkingBalance);
        // NINJA BONUS: In the constructor, 
        //call the private method from above so that each user has a random ten digit account.
        randomAccountNumber=getRandomDigitrandomAccountNumber();
        this.ID=BankAccount.numberOfAccounts;
        

    }




    // Getters Methods getCheckingBalance & getSavingsBalance & getNumberOfbankAccounts
    // Create a getter method for the user's checking account balance.
    public double getCheckingBalance(){
        return this.checkingBalance;
    }


    // Create a getter method for the user's saving account balance.
    public double getSavingsBalance(){
        return this.savingsBalance;
    }

    public static int getNumberOfbankAccounts(){
        return numberOfAccounts;
    }
    
    // Create a method that will allow a user to deposit money into either the checking or saving, 
    // be sure to add to total amount stored.
    public void depositMoney(String account, double amount){
            
            if(account.equals("checking")){
                this.checkingBalance+=amount ;
                totalAmountStored+=amount;
            }else if(account.equals("savings")){
                this.savingsBalance+=amount ;
                totalAmountStored+=amount;
            }else{
                System.out.println("Error : please enter the right name bank account to make deposite");
            }        
    }

    // Create a method to withdraw money from one balance.
    // Do not allow them to withdraw money if there are insufficient funds.
    public void withDraw(String account,double amount){
        if((this.checkingBalance > amount) && (account=="checking")){
            this.checkingBalance-=amount;
            totalAmountStored-=amount;
        }
        else if((this.savingsBalance > amount) && (account=="savings")){
            this.savingsBalance-=amount;
            totalAmountStored-=amount;
        }
        else{
            System.out.println("Insufficient funds in your Account");
        }
    }

    // Create a method to see the total money from the checking and saving.
    public static double getTotalMoneyStored(){
        return totalAmountStored;
    }

    // NINJA BONUS: Create a private method that returns a random ten digit account number.
    public static int getRandomDigitrandomAccountNumber(){
        Random randomDigitNumber=new Random();
        randomAccountNumber=randomDigitNumber.nextInt(10);
        randomAccountNumber+=1;
        return randomAccountNumber;
    }

    // Create a method to see the total money from the checking and saving of one BankAccount
    public double getTotalOneBankAccount(){
        double total=this.checkingBalance+this.savingsBalance;
        return total;
    }

    // optional :getter method for the id of bankAccount instance
    public int getId(){
        return ID;
    }

}

