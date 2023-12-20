public class TestBankAccount{
    public static void main(String[] args){

        // create instance from BankAccount class
        BankAccount moneemBankAccount=new BankAccount();
        BankAccount juliaBankAccount=new BankAccount();
        BankAccount samBankAccount=new BankAccount();




        // test haw many number Accounts in the Bank
        System.out.println("----------number of Accounts-----------");
        System.out.println(BankAccount.getNumberOfbankAccounts());

        // test checkingBalance of bank account 1
        System.out.println("----------checking Balance of bank account id: "+moneemBankAccount.getId()+"-----------");
        System.out.println("Checking balance : $"+moneemBankAccount.getCheckingBalance());

        
        // test savingsBalance of bank account 1
        System.out.println("----------Savings Balance of bank account id "+moneemBankAccount.getId()+"-----------");
        System.out.println("Savings balance : $"+moneemBankAccount.getSavingsBalance());



        // test Deposit Method
        System.out.printf("the current Savings balance : $%s ,and the Checking balance :$%s \n",moneemBankAccount.getSavingsBalance(),moneemBankAccount.getCheckingBalance());
        
        System.out.println("----------Bank account "+moneemBankAccount.getId()+" after 1st deposit money-----------\n");
        moneemBankAccount.depositMoney("checking",100);
        System.out.printf("the current Savings balance : $%s ,and the Checking balance :$%s \n",moneemBankAccount.getSavingsBalance(),moneemBankAccount.getCheckingBalance());
        
        System.out.println("----------Bank account "+moneemBankAccount.getId()+" after 2nd deposit money-----------\n");
        moneemBankAccount.depositMoney("savings",1000);
        System.out.printf("the current Savings balance : $%s ,and the Checking balance :$%s \n",moneemBankAccount.getSavingsBalance(),moneemBankAccount.getCheckingBalance());

        System.out.println("----------Bank account "+moneemBankAccount.getId()+" after 3rd deposit money-----------\n");
        moneemBankAccount.depositMoney("checking",1000);
        System.out.printf("the current Savings balance : $%s ,and the Checking balance :$%s \n",moneemBankAccount.getSavingsBalance(),moneemBankAccount.getCheckingBalance());

        System.out.println("----------Bank account "+samBankAccount.getId()+" after 1st deposit money-----------\n");
        samBankAccount.depositMoney("checking",3000);
        System.out.printf("the current Savings balance : $%s ,and the Checking balance :$%s \n",samBankAccount.getSavingsBalance(),samBankAccount.getCheckingBalance());


        
        // test withdraw 
        System.out.println("----------Bank account "+moneemBankAccount.getId()+" after 1st withdraw money-----------\n");
        moneemBankAccount.withDraw("savings",20);
        System.out.printf("the current Savings balance : $%s ,and the Checking balance :$%s \n",moneemBankAccount.getSavingsBalance(),moneemBankAccount.getCheckingBalance());
        System.out.println("----------Bank account "+moneemBankAccount.getId()+" after 2nd withdraw money-----------\n");
        moneemBankAccount.withDraw("checking",700);
        System.out.printf("the current Savings balance : $%s ,and the Checking balance :$%s \n",moneemBankAccount.getSavingsBalance(),moneemBankAccount.getCheckingBalance());
        System.out.println("----------Bank account "+moneemBankAccount.getId()+" after 3rd withdraw money-----------\n");
        moneemBankAccount.withDraw("checking",10000);

        // test get Total Money into a specific bankAccount 
        System.out.println("----------Total Money in specific BankAccount after withdraw and deposite is  :-----------\n");
        System.out.println("The total money in the bank "+moneemBankAccount.getId()+" today is :" +moneemBankAccount.getTotalOneBankAccount());

        // test get Total Money Stored in the bank
        System.out.println("----------Total Money stored in the bank after withdraw and deposite is  :-----------\n");
        System.out.println("The total money stored in the bank today is : "+ BankAccount.getTotalMoneyStored());

        // get the random number of specific bank account
        System.out.println("----------get the random number of specific bank account :-----------\n");
        System.out.println("The random account number of  is : "+ moneemBankAccount.getRandomDigitrandomAccountNumber());

    }

}