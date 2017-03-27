package edu.miracosta.cs113.hw7.project1;

/**
 * Created by Andrew Michel on 3/25/2017.
 * This program contains methods to recursively iterate over an ArrayList of Integer
 * to determine if the ArrayList contains any subset combinations which equal a target number
 * then outputs all matching combinations
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberSubset
{
    // Declares variables
    private static ArrayList<ArrayList<Integer>> doubleList = new ArrayList<>();


    public static int staticTarget;

    // main start
    public static void main(String[] args)
    {
        // Declares variables
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Integer> aList = new ArrayList<>();
        int iteration = 1, input;
        boolean goodInput = true;
        boolean badTarget = true;

        // Prompts user to enter target and provides instructions
        System.out.println("I will accept a target number and a subset of numbers");
        System.out.println("I will determine what combination of the subset numbers equal the target");

        do {
            try
            {
                // Prompts user to enter target value, stores it, and allows loop to end
                System.out.print("Enter the target number: ");
                staticTarget = keyboard.nextInt();

                badTarget = false;
            }
            catch(InputMismatchException e)
            {
                // Fixes buffer issues
                keyboard.nextLine();

                // Prompts user to enter a proper value
                System.out.println("Enter a valid target number");

                // Keeps loop going
                badTarget = true;
            }
        }while(badTarget);

        // Prints a newline
        System.out.println();

        do {

            try
            {
                // Prompts user to add a subset number and adds it to the list
                System.out.print("Enter subset number #" + iteration++ + ": ");
                input = keyboard.nextInt();
                aList.add(input);

                // Keeps loop going
                goodInput = true;
            }
            catch(InputMismatchException e)
            {
                // Allows loop to end
                goodInput = false;
            }

        }while(goodInput);

        // Calls recursive wrapper method
        subsetWrapper(aList, staticTarget);
    }// main end

    /**
     * Recursive wrapper method
     * @param aList Integer ArrayList parameter containing a subset of numbers
     * @param target int a number which is attempted to be summed to using the
     *               subset numbers
     */
    public static void subsetWrapper(ArrayList<Integer> aList, int target)
    {
        staticTarget = target;

        // subset recursion
        subsetRecursion(aList, 0);
        // subsetDisplay
        subsetDisplay();
    }

    /**
     * Recursive method
     * @param aList ArrayList of Integer which contains a subset of numbers
     * @param index int current position within the ArrayList parameter
     */
    private static void subsetRecursion(ArrayList<Integer> aList, int index)
    {
        if(staticTarget == addNumbers(aList))// base case start
        {
            addList(aList);

            return;
        }// base case end
        else if(aList.isEmpty() || index == aList.size())
        {
            return;
        }
        else
        {
            ArrayList<Integer> bList = new ArrayList<Integer> (aList);
            bList.remove(index);

            // recursion
            subsetRecursion(aList, index + 1);
            subsetRecursion(bList, index);
        }

    }

    /**
     *
     * @param aList ArrayList of Integer containing a subset of numbers
     * @return the total of the numbers within ArrayList parameter
     */
    private static int addNumbers(ArrayList<Integer> aList)
    {
        int total = 0;

        for(int iter : aList)
        {
            total += iter;
        }

        return total;
    }

    /**
     * Adds the ArrayList parameter to static doubleList ArrayList of ArrayList
     * if it does not already exist within doubleList
     * @param aList ArrayList of Integer containing a subset of numbers
     */
    private static void addList(ArrayList<Integer> aList)
    {
        for(ArrayList<Integer> number : doubleList)
        {
            if(aList.equals(number))
            {
                return;
            }
        }
        doubleList.add(aList);
    }

    /**
     * Iterates over the ArrayLists within static doubleList
     * and outputs the elements within the inner ArrayLists
     */
    private static void subsetDisplay()
    {
        for(ArrayList<Integer> combination : doubleList)
        {
            System.out.println(combination);
        }
    }
}
