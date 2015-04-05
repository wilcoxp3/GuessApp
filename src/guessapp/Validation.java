/*
 * The Validation class contains three static methods for input validation.
 * The getInt method receives a valid integer from the user. An overloaded version
 * of getInt also accepts a mininum and maximum allowed value for the integer.
 * The getContinue method returns a Boolean indicating the user's choice to 
 * continue or quit.
 */

package guessapp;
import java.util.Scanner;
public class Validation
{
    //getInt
    //prompts user to enter an interger
    //returns a valid integer
    public static int getInt(String prompt)
    {
        //create new Scanner object and declare and initialize user choice to 0
        Scanner sc = new Scanner(System.in);
        int i = 0;
        
        //loop until user enters a valid int
        while (true)
        {
            System.out.print(prompt);
            if (sc.hasNextInt())
            {
                i = sc.nextInt();
                break;
            }
            else
            {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();
        }
        return i;
    }
    
    //overloaded getInt to accept minimum and maximum values 
    public static int getInt(String prompt, int min, int max)
    {
        while (true)
        {
            int i = getInt(prompt);
            if (i < min)
            {
                System.out.println("Error! Integer must be from " + min + " to " + max);
            }
            else if (i > max)
            {
                System.out.println("Error! Integer must be from " + min + " to " + max);
            }
            else
            {
                return i;
            }
        }
    }
    
    //getContinue
    //prompts the user to continue by entering 'y' or 'n'
    //returns boolean true or false corresponding to yes or no respectively
    public static boolean getContinue(String prompt)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        boolean answer;
        String choice = sc.next();
        
        while(true)
        {
            if (choice.equalsIgnoreCase("y"))
            {
                answer = true;
                break;
            }
            else if (choice.equalsIgnoreCase("n"))
            {
                answer = false;
                break;
            }   
            else
            {
                System.out.print("Invalid choice. Please choose 'Y' or 'N': ");
                sc.nextLine();
                choice = sc.next();
            }
        }
        return answer;
    }
}