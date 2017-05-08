package edu.miracosta.cs113.hw011.project1;

import edu.miracosta.cs113.hw011.project1.studentcode.AVLTree;

import java.util.Iterator;

/**
 * Created by Andrew Michel on 4/30/2017.
 */
public class Driver
{
    public static void main(String[] args)
    {
        AVLTree<Integer> tree = new AVLTree<>();

        Iterator<Integer> iterator;

        String elements = populateTree(tree);

        // ITERATOR MUST BE INITIALIZED AFTER TREE POPULATION
        iterator = tree.iterator();

        System.out.println("AVLTREE PRESORT: ");

        System.out.println(elements);

        System.out.println("\nAVLTREE POSTSORT: ");

        while(iterator.hasNext())
        {
            System.out.println("Element: " + iterator.next());
        }

        System.out.println();
    }

    /**
     *
     * @param tree AVLTree that has elements added into it
     * @return elements a String containing the elements added into the AVLTree
     */
    public static String populateTree(AVLTree<Integer> tree)
    {
        String elements = "";

        int currentElement = -1;

        final int iteration = 15;

        for(int i = 0; i < iteration; i++)
        {
            currentElement = (int) ((Math.random() * 1000) + 1);

            if(i == 0)
            {
                elements = elements + currentElement;
            }
            else
            {
                elements = elements + ", " + currentElement;
            }

            tree.add(currentElement);
        }

        return elements;
    }
}
