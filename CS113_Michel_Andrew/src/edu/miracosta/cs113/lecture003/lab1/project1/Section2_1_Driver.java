package edu.miracosta.cs113.lecture003.lab1.project1;

/**
 * Created by Andrew Michel on 2/6/2017.
 */


/**
 * This driver takes stores user input in an ArrayList of Strings then uses
 * static methods to replace and delete elements inside the ArrayList
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Section2_1_Driver
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        ArrayList<String> myList = new ArrayList<String>(10);

        String userInput = "", toDelete = "", toReplace = "", replacement = "";

        System.out.println("Enter 'end' to proceed");

        while(!userInput.equalsIgnoreCase("End"))
        {
            System.out.print("Enter some String: ");

            userInput = keyboard.nextLine();

            if(!userInput.equalsIgnoreCase("End"))
            {
                myList.add(userInput);
            }
        }

        System.out.print("Enter a String that will be replaced: ");

        toReplace = keyboard.nextLine();

        System.out.print("Enter a String that will replace it: ");

        replacement = keyboard.nextLine();

        System.out.print("Enter a String that will be deleted: ");
        toDelete = keyboard.nextLine();

        System.out.println("\nBERFORE CHANGES: ");
        printStringArrayList(myList);

        Section2_1_Exercise1.replace(myList, toReplace, replacement);
        Section2_1_Exercise2.delete(myList, toDelete);

        System.out.println("\nPOST CHANGES: ");
        printStringArrayList(myList);
    }

    /**
     *  Iterates over the parameter and calls toString() on elements to print
     * @param aList ArrayList<String> that is iterated to print elements
     */
    public static void printStringArrayList(ArrayList<String> aList)
    {
        for(int i = 0; i < aList.size(); i++)
        {
            System.out.println(aList.get(i).toString());
        }
    }
}
