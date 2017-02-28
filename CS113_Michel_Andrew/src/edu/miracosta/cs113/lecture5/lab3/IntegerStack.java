package edu.miracosta.cs113.lecture5.lab3;

/**
 * Created by Andrew Michel on 2/27/2017.
 * This program demonstrates moving Integers from a stack into
 * a queue and another stack and displays the elements inside both stacks and queues
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IntegerStack
{
    public static void main(String[] args)
    {
        Stack<Integer> stacky = new Stack<Integer>();
        Stack<Integer> stacker = new Stack<Integer>();
        Queue<Integer> que = new LinkedList<>();

        // Problem 1
        push99(stacky);

        System.out.println("Checking first integer on stack...");
        System.out.println("First integer on stack is: " + stacky.peek());

        // Problem 2
        System.out.println("\nMoving integers from stack to queue and stack");
        pop99(stacky, stacker, que);

        // Problem 3
        System.out.println("\nEmptying queue and stack...\n");
        popEm(stacker, que);

    }

    /**
     *
     * @param sta Stack of Integers that will have values pushed to it
     */
    public static void push99(Stack<Integer> sta)
    {
        sta.push(-1);
        sta.push(15);
        sta.push(23);
        sta.push(44);
        sta.push(4);
        sta.push(99);
    }

    /**
     *
     * @param sta Stack of Integers that will have its elements printed and added into the other parameters
     * @param ker Stack of Integers that will receive the values from sta parameter
     * @param ue Queue of Integers that will receive the values from sta parameter
     */
    public static void pop99(Stack<Integer> sta, Stack<Integer> ker, Queue<Integer> ue)
    {
        int giant = sta.size();

        for(int i = 0; i < giant; i++)
        {
            System.out.println("Popping from stack: " + sta.peek());
            ker.push(sta.peek());
            ue.offer(sta.pop());
        }
    }

    /**
     *
     * @param ker Stack of Integers that will have its elements printed popped
     * @param ue Queue of Integers that will have its elements printed and removed
     */
    public static void popEm(Stack<Integer> ker, Queue<Integer> ue)
    {
        int giant = ker.size();

        for(int i = 0; i < giant; i++)
        {
            System.out.print("Popped from stack: " + ker.pop() + " ");
            System.out.print("Removed from queue: " + ue.remove() + "\n");
        }
    }
}
