package edu.miracosta.cs113.hw001.lab1;

/**
 * Created by Andrew Michel on 1/28/2017.
 */
public class Homework1Lab1
{
    // main method
    public static void main(String[] args)
    {
        fizzBuzz();
    }

    /**
     *
     * Iterates through 1 to 100 and prints the current number if it is not a multiple of 3 or 5.
     * For multiples of 3 print "Fizz", for multiples of 5 print "Buzz", for multiples of 3 and 5
     * print FizzBuzz
     */
    public static void fizzBuzz()
    {
        for(int i = 0; i <= 100; i++)
        {
            if(i % 3 != 0 && i % 5 != 0)
            {
                System.out.println(i);
            }
            else
            {
                if(i % 3 == 0)
                {
                    System.out.print("Fizz");
                }
                if(i % 5 == 0)
                {
                    System.out.print("Buzz");
                }

                // Prints a newline
                System.out.println();
            }
        }
    }
}
