package edu.miracosta.cs113.lecture005.lab2;

import java.util.Scanner;

/**
 * Created by w7237616 on 2/27/2017.
 */
public class ReverseStackDriver
{
    public static void main(String[] args)
    {
        ReverseStack<Character> stacky = new ReverseStack<Character>();

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
