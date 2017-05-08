package edu.miracosta.cs113.hw001.lab2;

/**
 * Created by Andrew Michel on 1/28/2017.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Homework1Lab2 {

    // main method
    public static void main(String[] args)
    {
        inputAndCheckNumber();
    }

    /**
     *
     * Calls takeInput() to take an integer from the user
     * Calls isAPowerOfTwo(value) with user input as parameter
     * Informs the user whether the input integer is or isn't a power of two
     */

    public static void inputAndCheckNumber()
    {
        System.out.println("I will take an integer as input and determine if it is a power of two");

        int number = takeInput();

        boolean powerOfTwo = isAPowerOfTwo(number);

        if(powerOfTwo)
        {
            System.out.println(number + " is a power of two");
        }
        else
        {
            System.out.println(number + " is not a power of two");
        }
    }

    /**
     *
     * @param value integer which will be iterated over and determined
     *              if it is a power of two
     * @return true if parameter is a power of two, otherwise false
     */

    public static boolean isAPowerOfTwo(int value)
    {
        boolean poweredByTwo = false;

        // Iterates through powers and two and checks if the current
        // power is equal to the parameter value
        // Note 2^0 is equal to 1
        for(int i = 1; i <= value; i *= 2)
        {
            if(value == i)
            {
                poweredByTwo = true;
            }
        }

        return poweredByTwo;
    }

    /**
     *
     * @return value an integer entered by the user
     *
     * Prompts the user to enter an integer while looping and
     * catching exceptions until an integer is entered
     */

    public static int takeInput()
    {
        Scanner keyboard = new Scanner(System.in);

        boolean badValue = true;
        int value = 0;

        while(badValue)
        {
            try
            {
                // Prompts and accepts input from user
                System.out.print("Please enter an integer value: ");
                value = keyboard.nextInt();
                badValue = false;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid input: " + e.getMessage());

                // Clears invalid characters from Scanner
                keyboard.nextLine();
            }
        }

        return value;
    }
}
