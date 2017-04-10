package edu.miracosta.cs113.hw8.project2;

import edu.miracosta.cs113.lecture8.studentcode.BinaryTree;
import edu.miracosta.cs113.lecture8.studentcode.BinarySearchTree;

import java.util.Iterator;

/**
 * page 357 project 8
 * Extend the BinaryTree Class to implement the Iterable interface
 * by providing an iterator.  The iterator should access the tree
 * elements using an inorder traversal.  The iterator is implemented
 * as a nested private class.
 * (Note: Unlike Node, this class should not be static.)
 *
 * Design hints:
 * You will need a stack to hold the path from the current node back
 * to the root.  You will also need a reference to the current node (current)
 * and a variable that stores the last item returned.  To initialize current,
 * the constructor should start at the root and follow the left links until
 * a node is reached that does not have a left child.  This node is the initial
 * current node.  The remove method can throw an UnsupportedOperationException.
 * The next method should use the following algorithm:
 *
 * 1. Save the contents of the current node.
 * 2. If the current node has a right child
 * 3.       Push the current node onto the stack
 * 4.       Set the current node to the right child.
 * 5.       While the current node has a left child.
 * 6.           Push the current node onto the stack.
 * 7.           Set the current node to the left child.
 * 8. Else the current node does not have a right child
 * 9.       While the stack is not empty and the top node
 *              of the stack's right child is equal to the current node
 * 10.          set the current node to the top of the stack and pop the stack
 * 11.      if the stack is empty
 * 12.          set the current node to null indicating that iteration is complete
 * 13.      else
 * 14.          set the current node to the top of the stack and pop the stack
 * 15. return the saved contents of the initial current node
 */

public class Driver
{
	public static void main(String[] args)
	{
		System.out.println("CREATING BINARY TREE");

		// Created as a BinarySearchTree because the BinaryTree class lacks simple
        // methods such as adding, removing, etc...
	    BinarySearchTree bt = new BinarySearchTree();

        StringBuilder data = new StringBuilder();

        bt.add(5);
        bt.add(3);
        bt.add(4);
        bt.add(2);
        bt.add(1);

        bt.add(7);
        bt.add(6);
        bt.add(8);

        /* Binary tree representation
                             5
                      3          7
                 2       4   6       8
             1
         */


        // Iterator must be initialized after elements are added
        Iterator iterator = bt.iterator();

        while(iterator.hasNext())
        {
            data.append(iterator.next() + " ");
        }

        System.out.println("DISPLAYING BREADTH FIRST TRAVERSAL: \n" + bt.breadthFirstTraversal());


        System.out.println("DISPLAYING INORDER TRAVERSAL ITERATOR RESULT: " + data.toString());
	}
}