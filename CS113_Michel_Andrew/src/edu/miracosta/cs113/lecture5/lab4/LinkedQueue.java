package edu.miracosta.cs113.lecture5.lab4;

/**
 * Created by Andrew Michel on 2/27/2017.
 * Queue delegated with a Doubly-LinkedList
 */

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LinkedQueue<E>
{
    public static String OFFER = "1", REMOVE = "2", POLL = "3", PEEK = "4", ELEMENT = "5", DISPLAY = "6", OPTIONS = "7", EXTERMINATE = "8";

    private LinkedList<E> que;

    public LinkedQueue()
    {
        que = new LinkedList<E>();
    }

    /**
     * Inserts item at the rear of the queue.  Returns true if
     * successful; returns false if the item could not be inserted
     * @param data
     * @return
     */
    public boolean offer(E data)
    {
        return que.add(data);
    }

    /**
     * Removes the entry at the front of the queue and returns it if
     * the queue is not empty.  If the queue is empty,
     * throws a NoSuchElementException
     * @return
     */
    public E remove()
    {
        if(que.get(0) == null)
        {
            throw new NoSuchElementException();
        }
        else
        {
            return que.removeFirst();
        }
    }

    /**
     * Removes the entry at the front of the queue and returns it;
     * returns null if the queue is empty
     * @return
     */
    public E poll()
    {
        return que.removeFirst();
    }


    /**
     * Returns the entry at the front of the queue without
     * removing it; returns null if the queue is empty
     * @return
     */
    public E peek()
    {
        return que.getFirst();
    }

    /**
     * Returns the entry at the front of the queue without removing it.
     * If the queue is empty, throws a NoSuchElementException
     * @return
     */
    public E element()
    {
        if(que.getFirst() == null)
        {
            throw new NoSuchElementException();
        }
        else
        {
            return que.getFirst();
        }
    }

    // main
    public static void main(String[] args)
    {
        menu();
    }

    /**
     *
     * Moving main contents to methods
     * Executes example program with LinkedQueue
     */
    public static void menu()
    {
        LinkedQueue<Integer> lq = new LinkedQueue<>();

        Scanner keyboard = new Scanner(System.in);

        String input = "";

        int value = 0;

        printOptions();

        do{
            System.out.print("Enter input: ");

            input = keyboard.nextLine();

            if(input.equals(OFFER))
            {
                value = getInput();

                System.out.println("Offer returned: " + lq.offer(value));
            }
            else if(input.equals(REMOVE))
            {
                System.out.println("Remove returned: " + lq.remove());
            }
            else if(input.equals(POLL))
            {
                System.out.println("Poll returned: " + lq.poll());
            }
            else if(input.equals(PEEK))
            {
                System.out.println("Peek returned: " + lq.peek());
            }
            else if(input.equals(ELEMENT))
            {
                System.out.println("Element returned: " + lq.element());
            }
            else if(input.equals(DISPLAY))
            {
                lq.displayQueue();
            }
            else if(input.equals(OPTIONS))
            {
                printOptions();
            }

        }while(!input.equals(EXTERMINATE));
    }

    public void displayQueue()
    {
        Object[] temp = que.toArray();

        for(int i = 0; i < temp.length; i++)
        {
            System.out.println(temp[i]);
        }
    }

    /**
     * Displays menu options
     */
    public static void printOptions()
    {
        System.out.println("Enter " + OFFER +  " to offer an integer");
        System.out.println("Enter " + REMOVE +  " to remove an integer");
        System.out.println("Enter " + POLL +  " to poll an integer");
        System.out.println("Enter " + PEEK +  " to peek at an integer");
        System.out.println("Enter " + ELEMENT +  " to element an integer");
        System.out.println("Enter " + DISPLAY + " to display all integers");
        System.out.println("Enter " + OPTIONS +  " to display options");
        System.out.println("Enter " + EXTERMINATE +  " to end program");
    }

    /**
     * Takes an int from the user via keyboard
     * @return input int from user
     */
    public static int getInput()
    {
        Scanner keyboard = new Scanner(System.in);

        boolean bad = true;

        int input = 0;

        do
        {
            prompt(0);

            try
            {
                input = keyboard.nextInt();

                bad = false;
            }
            catch(InputMismatchException e)
            {
                bad = true;
                System.out.println(e.getMessage());
            }

        }while(bad);

        return input;
    }

    /**
     * Prompts user to enter a value
     */
    public static void prompt(int i)
    {
        /*
        if(i == 0)
        {

        }
        else if(i == 1)
        {

        }
        else
        {

        }
         */

        System.out.print("Enter an integer value: ");
    }
}
