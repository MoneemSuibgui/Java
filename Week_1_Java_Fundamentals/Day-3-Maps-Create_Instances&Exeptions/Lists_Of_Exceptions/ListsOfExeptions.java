import java.util.ArrayList;
import java.lang.ClassCastException;
class ListsOfExeptions{
    public static void main(String[] args){
        
        /*
        Your new PM knows you don't know Java too well. 
        She wants you to familiarize yourself with generics and exceptions
        and figure out exactly how they work. First,
        she wants you to make an ArrayList with both numbers and strings in it.
        */

        // Task 1/ Create ArrayList And add sobjects to it
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add("Goodbye World");
        myList.add(48);


        /*
        You will loop through the list and try assigning each item 
        to an int variable. To do this,
        you will also need to cast your list item as an Integer;
        you can do this like this:
        */

         //  Task 3/ Try to cast each element to an Integer
        // Task 2/ Use try/catch blocks to handle the exceptions
            for(int i = 0; i < myList.size(); i++) {
                Integer castedValue = (Integer) myList.get(i);
                try{
                    System.out.printf("The Object  -- %s -- With index %s is cated to : %s\n \n" ,myList.get(i),i,castedValue);
                }
                catch(ClassCastException e){
                    System.out.println(e);
                    System.out.printf("Error Message  : The index of %s of Object with value is -- %s  -- cannot be cast to Integer \n",i,myList.get(i));
                }
                
            }
            System.out.println("End \n");
            System.out.println("New line of code here !");
    }
}