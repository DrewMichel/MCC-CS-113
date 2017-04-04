package edu.miracosta.cs113.hw8.project1;

import edu.miracosta.cs113.lecture8.studentcode.BinaryTree;

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

public class Driver
{
	public static void main(String[] args)
	{
		System.out.println("CREATING BINARY TREE");
	    BinaryTree bt = new BinaryTree();

	    System.out.println("ENDING PROGRAM");
	}
}