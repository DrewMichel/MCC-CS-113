package edu.miracosta.cs113.hw006.project2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Created by Andrew Michel on 3/11/2017.
 *
 * This class takes the amount of change that must be refunded as input from user
 * then recursively displays all possible change combinations consisting of
 * quarters, dimes, nickels, and pennies
 */

public class Change
{
	public static final int[] coins = {25, 10, 5, 1};
	
	public static void main(String[] args)
	{
        Scanner keyboard = new Scanner(System.in);

        int input = 0;

        boolean badInput = true;

	    do
        {
            System.out.print("Enter the amount of change in cents that must be refunded: ");

            try
            {
                input = keyboard.nextInt();
                badInput = false;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Enter a valid number!");
                keyboard.nextLine();
            }

        }while(badInput == true);

	    System.out.println("Displaying change combinations for " + input + " cents\n");

		giveChange(new ArrayList<Integer> (), 0,input);

        System.out.println("\nFinished displaying combinations for " + input + " cents");
	}

    /**
     *
     * @param aList ArrayList of Integer which has coin values of 25, 10, 5, and 1 added and removed from it
     * @param index int which determines what coin value should be added into aList, used as index for int array coins
     * @param change int value for the amount of change remaining
     */
	public static void giveChange(ArrayList<Integer> aList, int index, int change)
    {
        if(change <= 0)
        {
            // iterate through ArrayList and display coin types
            displayCoins(aList);
        }
        else
        {
            if(coins[index] <= change)
            {
                // Adds a coin into ArrayList based on index
                aList.add(coins[index]);
                // System.out.println("ADDING: " + aList.get(aList.size() - 1));

                // Recursive call, with change reduced by the amount added to ArrayList
                giveChange(aList, index, change - coins[index]);

                // System.out.println("REMOVING : " + aList.get(aList.size() - 1));

                // Removes the top most coin from the ArrayList
                aList.remove(aList.size() - 1);
            }
            if(coins.length > 1 + index)
            {
                // Recursive call, with index increased by one
                // moves up from quarter to dime to nickel to penny
                giveChange(aList, 1 + index, change);
            }
        }
    }

   /**
    * For coin values of 25, 10, 5, and 1, the number of
    * quarters, dimes, nickels, and pennies are displayed
    * @param aList ArrayList of Integer which is iterated over
    *
    */
    public static void displayCoins(ArrayList<Integer> aList)
    {
        if(aList != null)
        {
            ListIterator iterator = aList.listIterator();

            Integer i;

            int quarters = 0, dimes = 0, nickels = 0, pennies = 0;

            while(iterator.hasNext())
            {
                i = (Integer) iterator.next();

                if(i == coins[0])
                {
                    quarters++;
                }
                else if(i == coins[1])
                {
                    dimes++;
                }
                else if(i == coins[2])
                {
                    nickels++;
                }
                else if(i == coins[3])
                {
                    pennies++;
                }
            }

            if(quarters > 0)
            {
                System.out.print("Quarters: " + quarters + " ");
            }
            if(dimes > 0)
            {
                System.out.print("Dimes: " + dimes + " ");
            }
            if(nickels > 0)
            {
                System.out.print("Nickels: " + nickels + " ");
            }
            if(pennies > 0)
            {
                System.out.print("Pennies: " + pennies);
            }

            System.out.println();
        }
    }
}