package edu.miracosta.cs113.hw8.project1;

import edu.miracosta.cs113.lecture8.studentcode.BinarySearchTree;

/**
 * page 357 project 6
 * In a breadth-first traversal of a binary tree, the nodes are visited
 * in an order prescribed by their level.  First visit the node at
 * level 1, the root node.  Then visit the nodes at level 2, in
 * left-to-right order, and so on.  You can use a queue to implement a
 * breadth-first traversal of a binary tree.
 *
 * Algorithm for breadth-first traversal of a binary tree
 * 1. Insert the root node in the queue.
 * 2. While the queue is not empty
 * 3.       Remove a node from the queue and visit it.
 * 4.       Place the reference to its left and right subtrees in the queue.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver
{
	public static void main(String[] args)
	{
	    BinarySearchTree bst = new BinarySearchTree();

        Scanner keyboard = new Scanner(System.in);

        String input = "";

        System.out.println("Enter simulate to run automated examples");
        System.out.println("Enter any other input to manually input numbers");

        input = keyboard.nextLine();

        if(input.toLowerCase().equals("simulate") == true)
        {
            simulate(bst);
        }
        else
        {
            process(bst);
        }
	}

    /**
     * Populates a BinarySearchTree with consistent elements
     * @param tree a BinarySearchTree which elements are added into
     *
     */
	public static void populateTree(BinarySearchTree tree)
    {
        for(int i = 0; i < 20; i++)
        {
            tree.add(i);
        }
    }

    /**
     * Populates a BinarySearchTree with random elements
     * @param tree a BinarySearchTree which elements are added into
     *
     */
    public static void populateTreeRandom(BinarySearchTree tree)
    {
        int currentNumber = 0;

        System.out.println("RANDOM NUMBERS PRE POPULATION: " );

        for(int i = 1; i < 101; i++)
        {
            currentNumber = (int) (Math.random() * 100);

            System.out.printf("%3d ", currentNumber);

            if(i % 20 == 0)
            {
                System.out.println();
            }

            tree.add(currentNumber);
        }

        System.out.println();
    }

    /**
     * Calls the populateTreeRandom method with param as param then displays the elements
     * @param tree a BinarySearchTree which is used to simulate adding elements into
     */
    public static void simulate(BinarySearchTree tree)
    {
        String data = "";

        //populateTree(tree);

        populateTreeRandom(tree);

        data = tree.breadthFirstTraversal();

        System.out.println("RANDOM DATA POST POPULATION: \n" + data);
    }

    /**
     * Prompts user to enter integers into param then displays all elements
     * @param tree a BinarySearchTree which user input is added into
     */
    public static void process(BinarySearchTree tree)
    {
        Scanner keyboard = new Scanner(System.in);

        boolean end = false;
        int currentValue = 0;
        int index = 0;

        while(end == false)
        {
            try
            {
                System.out.print("Enter #" + ++index + ": ");

                currentValue = keyboard.nextInt();

                tree.add(currentValue);
            }
            catch(InputMismatchException e)
            {
                end = true;
                System.out.println("Ending input");
            }
        }

        System.out.println("DATA POST POPULATION: \n" + tree.breadthFirstTraversal());
    }
}