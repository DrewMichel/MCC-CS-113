package edu.miracosta.cs113.hw2.project1;

/**
 * Created by Andrew Michel on 2/6/2017.
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Homework2Project1
{
    public static void main(String[] args)
    {
        ArrayList<Food> foodList = new ArrayList<> ();

        Scanner keyboard = new Scanner(System.in);

        Food yummy;

        boolean quit = false;

        int userInput = 0;

        System.out.println("I will estimate your daily nutritional information");

        printOptions();

        while(quit == false)
        {
            try
            {
                userInput = keyboard.nextInt();

                switch (userInput)
                {
                    case 1: yummy = new MeatsEggsNuts();
                            yummy.setCalories(280);
                            foodList.add(yummy);
                            break;

                    case 2: yummy = new Fruits();
                            yummy.setCalories(90);
                            foodList.add(yummy);
                            break;

                    case 3: yummy = new FatsOilsSweets();
                            yummy.setCalories(350);
                            foodList.add(yummy);
                            break;

                    case 4: yummy = new MilkBased();
                            yummy.setCalories(110);
                            foodList.add(yummy);
                            break;

                    case 5: yummy = new Vegetables();
                            yummy.setCalories(50);
                            foodList.add(yummy);
                            break;

                    case 6: yummy = new Wheats();
                            yummy.setCalories(180);
                            foodList.add(yummy);
                            break;

                    case 7: displayNutritionalValues(foodList);
                            break;

                    case 8: printOptions();
                            break;
                    default: quit = true;
                             break;
                }
            }
            catch(InputMismatchException e)
            {
                quit = true;
            }
        }
    }

    public static void printOptions()
    {
        System.out.println("Enter 1 to add a Meat, Egg, or Nut");
        System.out.println("Enter 2 to add a Fruit");
        System.out.println("Enter 3 to add a Fat, Oil, or Sweet");
        System.out.println("Enter 4 to add a Milk based product");
        System.out.println("Enter 5 to add a Vegetable");
        System.out.println("Enter 6 to add a Wheat product");
        System.out.println("Enter 7 to display nutritional information");
        System.out.println("Enter 8 to view options again");
        System.out.println("Enter any other character to exit");
    }

    public static void displayNutritionalValues(ArrayList<Food> listOfFood)
    {
        double totalCalories = 0, totalCarbs = 0, totalFats = 0, totalProteins = 0;

        double percentCarbs = 0, percentFats = 0, percentProteins = 0;

        for(Food i: listOfFood)
        {
            totalCalories += i.getCalories();
            totalCarbs += i.percentCarbohydrates();
            totalFats += i.percentFat();
            totalProteins += i.percentProtein();
        }

        System.out.println("Estimated total calories: " + totalCalories);
        System.out.println("Estimated total carbs: " + totalCarbs);
        System.out.println("Estimated total fats: " + totalFats);
        System.out.println("Estimated total proteins: " + totalProteins);

        percentCarbs = (totalCarbs / totalCalories) * 100;
        percentFats = (totalFats / totalCalories) * 100;
        percentProteins = (totalProteins / totalCalories) * 100;
        System.out.printf("Diet consists of: %.2f%% carbs,  %.2f%% fats, and %.2f%% proteins", percentCarbs, percentFats, percentProteins);
    }
}
