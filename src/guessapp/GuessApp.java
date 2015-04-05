/*
 * Workbook Project 5-3 (Guess a number from 1 to 100)
 * Professor: Tedd Sperling
 * Course: Introduction to JAVA - (22150)
 * Student: Paul Wilcox
 * This program prompts the user to guess a randomly generated integer from 1 to
 * 100, counting the number of guesses until the guess is correct. It also tells 
 * the user whether their incorrect guesses are too high or too low. Upon guessing
 * correctly, the user is given the option to continue or quit.
*/

package guessapp;

public class GuessApp
{
    public static void main(String[] args)
    {
        //print opening prompt
        System.out.println("Welcome to the Guess the Number Game");
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println("\nI'm thinking of a number from 1 to 100.");
        System.out.println("Try to guess it.");
        
        //Fetch random integer from 1 to 100.
        //Declare and initialize number of user guesses to 0.
        int computerChoice = Function.getRandIntRange(1, 100);
        int tries = 0;
        
        while (true)
        {
            //Get user guess within specified range, increment number of tries
            int userGuess = Validation.getInt("\nEnter number: ", 1, 100);
            tries++;
            
            //find difference between user's guess and random number
            int difference = userGuess - computerChoice;
            
            //Display varying prompts according to direction and mangnitude
            //of difference.
            if (difference > 10)
            {
                System.out.println("Way too high! Guess again.");
            }
            else if (difference <= 10 && difference > 0)
            {
                System.out.println("Too high! Guess again.");
            }
            else if (difference < 0)
            {
                System.out.println("Too low! Guess again.");
            }
            
            //user guesses correctly
            else
            {
                //Display varying messages according to how many guesses the user
                //took.
                System.out.println("You got it in " + tries + " tries.");
                if (tries <= 3)
                {
                    System.out.println("Great work! You are a mathematical wizard.");
                }
                else if (tries > 3 && tries <= 7)
                {
                    System.out.println("Not too bad! You've got some potential.");
                }
                else
                {
                    System.out.println("What took you so long? Mybe you should take some lessons.");
                }
                
                //Prompt user to continue or quit
                if (Validation.getContinue("\nTry again? (y/n): ") == false)
                {
                    System.out.println("\nBye - Come back soon!");
                    break;
                }
                
                //If continuing, get new random integer
                else
                {
                    computerChoice = Function.getRandIntRange(1, 100);
                    tries = 0;
                }
            }
        }
        System.out.println("DONE");
    }
}
