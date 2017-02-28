package edu.miracosta.cs113.lecture5.lab1;

/**
 * Created by Andrew Michel on 2/27/2017.
 * Takes a String as input from user and reverses it onto a StringBuilder using a Stack
 */

import java.util.Stack;
import java.util.Scanner;

public class ReverseString
{
    public static void main(String[] args)
    {
        Stack<Character> stacky = new Stack<Character>();

        Scanner keyboard = new Scanner(System.in);
        String userInput = "";
        StringBuilder reversedInput = new StringBuilder();
        String repeat = "";

        do
        {
            reversedInput.delete(0, reversedInput.length());

            System.out.print("GIMME DAT STRING: ");
            userInput = keyboard.nextLine();

            System.out.println("\nBEFORE STACK");
            System.out.println(userInput + "\n");

            for(int i = 0; i < userInput.length(); i++)
            {
                stacky.push(userInput.charAt(i));
            }

            for(int i = 0; i < userInput.length(); i++)
            {
                reversedInput.append(stacky.pop());
            }

            System.out.println("POST STACK");
            System.out.println(reversedInput  + "\n");

            System.out.println("Enter Y to repeat or N to exit: ");
            repeat = keyboard.nextLine();

        }while(repeat.equalsIgnoreCase("Y"));

        System.out.println("Ending program");
    }
}
