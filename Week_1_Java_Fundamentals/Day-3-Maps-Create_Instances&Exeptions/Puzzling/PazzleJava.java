import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;


class PazzleJava{
    
    // Write a method that will generate and return an array with 10 random numbers between 1 and 20 inclusive.

    public void getTenRolls(){
        // create fixed array with length 10
        int[] myRandomArray = new int[10] ;
        Random randomNumbers= new Random();
        for(int i=0;i<10;i++){
                // generate number from 1 to 10 
                int n=randomNumbers.nextInt(1,21);
                // stroed the random number in the array
                myRandomArray[i]=n;
                System.out.println(myRandomArray[i]);
            }
        }



    // Create an array within the method 
    // that contains all 26 letters of the alphabet (this array must have 26 values)
    // Generate a random index between 0-25 and use it to pull a random letter out of the array

    public void getRandomLetter(){
        // create fixed array 
        char[] myRandomArray = new char[26] ;
        Random randomChar= new Random();
        String allCharacters="abcdefghijklmnopqrstuvwxyz";
        //  Generate a random index between 0-25 
        for(int i=1;i<26;i++){ 
                //and use the index to pull a random letter out of the array
                char myChar= allCharacters.charAt(randomChar.nextInt(allCharacters.length()));
                System.out.println(myChar);
                // stroed the random character in the array
                myRandomArray[i]=myChar;
                
            }
        }


    // Write a method that uses the previous method to create a random string of eight characters and return that string.

        public String generatePassword(){
            Random randomChar= new Random();
            String allCharacters="abcdefghijklmnopqrstuvwxyz125778921@%$µ#";
            String password="";
            for(int i=0;i<8;i++){
                char myChar= (allCharacters.charAt(randomChar.nextInt(allCharacters.length()))) ;
                // System.out.println("my generator char is :"+myChar);
                password=password.concat(myChar+"");
            }
            // System.out.println("my password is :"+password);
            return password ;
        }


    //  Write a method that takes an int length as an argument and
    //  creates an array of random eight-character words. The array should be the length passed in as an int. 
    //  Return the array of passwords

        public String getNewPasswordSet(int num){
            ArrayList<Object> myPasswordArray = new ArrayList<Object>();
            Random randomCharacter=new Random();
            String phrase="abcdBDGARADSKCBRIEuvwxyz125778921@%$µ#";
            String mySetPassword="";
            for(int i=0;i<num;i++){
                char myChar= (phrase.charAt(randomCharacter.nextInt(phrase.length())));
                myPasswordArray.add(myChar);
                mySetPassword=mySetPassword.concat(myChar+"");
            }
            System.out.println(myPasswordArray);
            // System.out.println("My new Password is :"+ mySetPassword);
            return mySetPassword ;
        }

}



