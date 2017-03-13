package edu.miracosta.cs113.hw6.project2;

import java.util.Scanner;

public class Change
{
	private static Scanner keyboard = new Scanner(System.in);
	private static String pause;
	private static int iteration = 1;
	private static boolean firstRun = true;
	
	public static double QUARTER = 25, DIMES = 10, NICKELS = 5, PENNIES = 1;
	
	public static void main(String[] args)
	{
		giveChange(26);
	}
	
	// Return String instead??
	
	/**
	 * Repeats of an individual coin inside a single iteration means it is involved with the next iteration
	 */
	public static void giveChange(double dollar)
	{
		if(firstRun)
		{
			firstRun = false;
			System.out.print("\nPAUSED: Enter any key to proceed: ");
		}
		pause = keyboard.nextLine();
		System.out.println();
		// Subtraction
		/*
		if(1 > dollar)
		{
			return;
		}
		if(dollar >= 25)
		{
			//System.out.println("Quarters: " + Math.round((dollar / 0.25)));
			System.out.println("Quarters: " + (int) (dollar / 25));
			if(dollar - 25 > 1)
			{
				System.out.println("Passing: " + (int) (dollar - 25) + " cents");
				giveChange(dollar - 25);
			}
			
		}
		if(dollar >= 10)
		{
			//System.out.println("Dimes: " + Math.round((dollar / 0.10)));
			System.out.println("Dimes: " + (int) (dollar / 10));
			if(dollar - 10 > 1)
			{
				System.out.println("Passing: " + (int) (dollar - 10) + " cents");
				giveChange(dollar - 10);
			}
		}
		if(dollar >= 5)
		{
			//System.out.println("Nickels: " + Math.round((dollar / 0.05)));
			System.out.println("Nickels: " + (int) (dollar / 5));
			
			if(dollar - 5 > 1)
			{
				System.out.println("Passing: " + (int) (dollar - 5) + " cents");
				giveChange(dollar - 5);
			}
			
		}
		if(dollar >= 1)
		{
			//System.out.println("Pennies: " + Math.round((dollar / 0.01)));
			System.out.println("Pennies: " + (int) (dollar / 1));
			giveChange(dollar % 1);
		}
		*/
		
		// Modulus
		/*
		if(1 > dollar)
		{
			return;
		}
		if(dollar >= 25)
		{
			//System.out.println("Quarters: " + Math.round((dollar / 0.25)));
			System.out.println("Quarters: " + (int) (dollar / 25));
			if(dollar - 25 > 1)
			{
				System.out.println("Passing: " + (int) (dollar % 25) + " cents");
				giveChange(dollar % 25);
			}
			
		}
		if(dollar >= 10)
		{
			//System.out.println("Dimes: " + Math.round((dollar / 0.10)));
			System.out.println("Dimes: " + (int) (dollar / 10));
			if(dollar - 10 > 1)
			{
				System.out.println("Passing: " + (int) dollar % 10 + " cents");
				giveChange((dollar % 10));
			}
		}
		if(dollar >= 5)
		{
			//System.out.println("Nickels: " + Math.round((dollar / 0.05)));
			System.out.println("Nickels: " + (int) (dollar / 5));
			
			if(dollar - 5 > 1)
			{
				System.out.println("Passing: " + (int) (dollar % 5) + " cents");
				giveChange(dollar % 5);
			}
			
		}
		if(dollar >= 1)
		{
			//System.out.println("Pennies: " + Math.round((dollar / 0.01)));
			System.out.println("Pennies: " + (int) (dollar / 1));
			giveChange(dollar % 1);
		}
		*/
		
		// Single coin
		
		if(1 > dollar)
		{
			return;
		}
		if(dollar >= 25)
		{
			//System.out.println("Quarters: " + Math.round((dollar / 0.25)));
			System.out.println("Quarters: " + 1);
			if(dollar - 25 >= 1)
			{
				System.out.println("Passing: " + (int) (dollar - 25) + " cents");
				giveChange(dollar - 25);
			}
			
		}
		if(dollar >= 10)
		{
			//System.out.println("Dimes: " + Math.round((dollar / 0.10)));
			System.out.println("Dimes: " + 1);
			if(dollar - 10 >= 1)
			{
				System.out.println("Passing: " + (int) (dollar - 10) + " cents");
				giveChange(dollar - 10);
			}
		}
		if(dollar >= 5)
		{
			//System.out.println("Nickels: " + Math.round((dollar / 0.05)));
			System.out.println("Nickels: " + 1);
			
			if(dollar - 5 >= 1)
			{
				System.out.println("Passing: " + (int) (dollar - 5) + " cents");
				giveChange(dollar - 5);
			}
			
		}
		if(dollar >= 1)
		{
			//System.out.println("Pennies: " + Math.round((dollar / 0.01)));
			System.out.println("Pennies: " + (int) (dollar / 1));
			giveChange(dollar % 1);
		}
		
		System.out.println("Current Iteration: " + iteration++ + "\n");
	}
}