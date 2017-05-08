package edu.miracosta.cs113.lecture003.lab1.project2;

import java.util.Scanner;

/**
 * Created by Andrew Michel on 2/6/2017.
 */

/**
 * This driver creates an object of Section2_2_Exercise1 which contains an ArrayList of DirectoryEntry
 * and methods to add or change, remove, or display entries.
 */
public class Section2_2_Driver
{
    public static final String ADD_OR_CHANGE = "1", REMOVE = "2", DISPLAY = "3", OPTIONS = "4", END = "5";

    public static void main(String[] args)
    {
        Section2_2_Exercise1 idk = new Section2_2_Exercise1();

        Scanner keyboard = new Scanner(System.in);

        String userInput = "", inputName = "", inputNumber = "";

        printOptions();

        while(!userInput.equalsIgnoreCase(END))
        {
            System.out.print("Enter input: ");

            userInput = keyboard.nextLine();

            if(userInput.equals(ADD_OR_CHANGE))
            {
                System.out.print("Enter name of entry to add or change: ");
                inputName = keyboard.nextLine();

                System.out.print("Enter number of entry: ");
                inputNumber = keyboard.nextLine();

                idk.addOrChangeEntry(inputName, inputNumber);
            }
            else if(userInput.equals(REMOVE))
            {
                System.out.println("Enter name of entry to remove: ");
                inputName = keyboard.nextLine();

                idk.removeEntry(inputName);
            }
            else if(userInput.equals(DISPLAY))
            {
                idk.displayEntries();
            }
            else if(userInput.equals(OPTIONS))
            {
                printOptions();
            }
        }
    }

    /**
     * Prints input prompts
     */
    public static void printOptions()
    {
        System.out.println("Enter " + ADD_OR_CHANGE + " to add or change an entry");
        System.out.println("Enter " + REMOVE + " to remove an entry");
        System.out.println("Enter " + DISPLAY + " to display all entries");
        System.out.println("Enter " + OPTIONS + " to display options");
        System.out.println("Enter " + END + " to end program");
    }
}
