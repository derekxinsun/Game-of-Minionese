/* COMP 248/ Summer 2017
 * Assignment #3 - Question 1 
 * Author: Xin Sun
 * Date: June 2017
 * Purpose: This program displays the comparison result between 
 * user input String array element and random array element
 */

//import methods 
import java.util.Random;
import java.util.Scanner;

public class Minionese  {
    public static void main(String[] args) {
    	String answer;// Declare a condition in do while loop
    	do// Use a do while loop to control if the user will play it again 
        {
            Random myGenerator = new Random();// Create a random object 
            String [] arr = new String[4]; // Create a array which will be used as the random array 
            
            for (int i = 0; i < 4; i++)// Use a for loop to trace the random array 
            	                       
            {
                int randomNumber = myGenerator.nextInt(4);// Assign the random number to this array index 
                if (randomNumber == 0)//and assign the value to each element of this random array
                {
                    arr[i] = "bella";
                }
                else if (randomNumber == 1)
                {
                    arr[i] = "kampai";
                }
                else if (randomNumber == 2)
                {
                    arr[i] = "papoy";
                }
                else if (randomNumber == 3)
                {
                    arr[i] = "banana";
                }
            }
            Scanner keyin = new Scanner(System.in);// Create an Scanner object 
            
            //Print out the title messages 
            // and ask for request 
            System.out.println("Let's play Minionese?");
            System.out.println("\nOK, I just thought of a sentence of 4 words among bella, kampai, papoy and banana.");
            System.out.println("\nYou have 6 attempts to guess it.");
            boolean win = false;
            System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " ");
            for (int t = 1; t <= 6; t++)
            {
                String [] arrModified = new String[4];// Create a array to copy random array 
                                                      
                for(int a =0;a<4;a++){
                	arrModified[a]=arr[a];// To copy the random array
                }
                int identical = 0; // Initialize identical frequency
                int correct = 0; //Initialize correct times
                String [] inputArr = new String[4];// Create an array for to get user input String value
                System.out.print("\nYour guess #" + t + ": ");// Displays frequency of guess 
                String first = keyin.next();// Assign the input value to each element of input array
                inputArr[0] = first;
                String second = keyin.next();
                inputArr[1] = second;
                String third = keyin.next();
                inputArr[2] = third;
                String fourth = keyin.next();
                inputArr[3] = fourth;
                
                for (int k = 0; k < 4; k++)// Use a for loop to trace identical frequency 
                {
                    if (arr[k].equals(inputArr[k]))
                    {
                        identical++;// Identical times
                        arrModified[k] = " ";// Record the used element of random array by assigning a new value
                        inputArr[k] = "i"; // Record the used element of input array by assigning a new value
                    }
                }
                for (int u = 0; u < 4; u++)// Use a  nestle for loop to trace identical frequency 
                {
                    for (int r = 0; r < 4; r++)
                    {
                        if (inputArr[u].equals(arrModified[r]))// Use copied random array element 
                        	                                   //in order to avoid disturb random array's comparison
                                                               //  during  tracing identical and correct frequency
                        {
                        	arrModified[r] = "o";// Record the used element of random array by assigning a new value
                            correct++;// Correct times
                        }
                    }
                }
                System.out.println("Identical words:" + identical);// Displays identical words number 
                System.out.println("Correct words:" + (correct));// Displays identical words number 
                if (identical == 4)// Check the guessing words are  completely identical to the random words
                {
                    win = true;
                    System.out.println("\nCongratulations!" + "\nYou found the sentence in "+t+" attempts!");
                    break;
                }
            }
        	
            if (!win)//  Right answer will display  after 6 times if the user doesn't get the right answer
            {
                System.out.println("\nSorry, the sentence was:"+ arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " ");
            }
            System.out.print("\nDo you want to play again? (yes/no): ");// Ask if the user will play again
            answer = keyin.next();// Create a user's wish to play again or not 
            if (answer.equals("no"))// If the user's input is no , the game is over
            {                       // If the user's input is yes, the game will start from the beginning
            	                    //( the program is still in the do while loop to implement the game ) 
                System.out.println("OK then. Bye bye.\n");
                //System.exit(0);
            }
        }while(answer.equals("yes"));// check user's positive wish to play again to 
    	                             //keep the game still can be implement via do while loop 
    	
    }
}
