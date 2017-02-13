package edu.miracosta.cs113.hw3.project1;

import java.util.ArrayList;

/**
 * Created by Andrew Michel on 2/13/2017.
 */
public class Driver
{
    public static void main(String[] args)
    {
        Chapter2_Project1<Assignment> linked = new Chapter2_Project1<Assignment>();

        Assignment toRemove = new Assignment("CS113", "Project9000", 5000, 1, 22);

        linked.add(new Assignment("CS130", "Project3.1", 2017, 2, 13));
        linked.add(new Assignment("CS130", "Project3.2", 2017, 2, 13));

        linked.add(toRemove);
        linked.add(new Assignment("CS113", "Project3", 2017, 1, 22));

        System.out.println("BEFORE CHANGES: ");

        ArrayList<Assignment> returnedList = linked.getArrayList();

        for(int i = 0; i < returnedList.size(); i++)
        {
            System.out.println(returnedList.get(i));
        }

        System.out.println("AFTER CHANGES: ");

        linked.remove(toRemove);

        ArrayList<Assignment> afterList = linked.getArrayList();

        for(int i = 0; i < afterList.size(); i++)
        {
            System.out.println(afterList.get(i));
        }

        System.out.println("\nDisplaying nearest due dates");
        linked.printUpcoming();

        System.out.println("ENDING");
    }
}
