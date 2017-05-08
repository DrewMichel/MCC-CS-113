package edu.miracosta.cs113.lecture010.lab2;

/**
 * Created by Andrew Michel on 4/17/2017.
 */

import java.util.Queue;
import java.util.LinkedList;

public class Radix
{
    public static void main(String[] args)
    {
        Queue<Integer>[] queues = new LinkedList[10];

        populateQueues(queues);

        Integer[] array = {2,5,10,9,4,11,15,3,4,10,16,19,500,1256,623,62,213,76,35,8,32,353,2345,1000,23};

        System.out.println("PRE SORT");
        displayArray(array);

        System.out.println("POST SORT");
        radixSort(queues, array);
        displayArray(array);

        //System.out.println("DISPLAYING QUEUES");
        //displayQueues(queues);

    }

    /**
     *
     * @param queues Array of Queues that contains Integers which
     *               is used as sorting buckets
     * @param array Integer array that has its elements sorted
     */
    public static void radixSort(Queue<Integer>[] queues, Integer[] array)
    {
        int divider = 1;
        int counter = 0;
        int multiplier = 10;
        int queuePos = 0;
        int arrayPos = 0;

        while(counter < 4)
        {
            queuePos = 0;
            arrayPos = 0;

            for(int i = 0; i < array.length; i++)
            {
                if(array[i] != null)
                {
                    queues[(array[i]  / divider) % queues.length].add(array[i]);
                }
            }

            while (queuePos < 10)
            {
                while(queues[queuePos].peek() != null)
                {
                    array[arrayPos] =  queues[queuePos].poll();
                    arrayPos++;
                }

                queuePos++;
            }

            divider *= multiplier;
            counter++;
        }
    }

    /**
     *
     * @param queues Array of Queues that contains Integers which
     *               has its queues initialized
     */
    public static void populateQueues(Queue<Integer>[] queues)
    {
        for(int i = 0; i < queues.length; i++)
        {
            queues[i] = new LinkedList<>();
        }
    }

    /**
     *
     * @param queues Array of Queues that contains Integers which
     *               have their elements displayed
     */
    public static void displayQueues(Queue<Integer>[] queues)
    {
        for(int i = 0; i < queues.length; i++)
        {
            for(Queue<Integer> queue : queues)
            {
                for(Integer integer : queue)
                {
                    if(integer != null)
                    {
                        System.out.print(integer);
                    }
                }
            }
        }

        System.out.println();
    }

    /**
     *
     * @param array Integer array that has its elements displayed
     */
    public static void displayArray(Integer[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }
}
