package edu.miracosta.cs113.lecture010.lab1;

/**
 * Created by Andrew Michel on 4/17/2017.
 */
public class Driver
{
    public static void main(String[] args)
    {
        Integer[] array = new Integer[10];

        populateArray(array);

        System.out.println("PRE SORT");
        displayArray(array);

        System.out.println("POST SORT");
        bubbleSort(array);
        displayArray(array);
    }

    /**
     *
     * @param array Integer array that is sorted in ascending order
     */
    public static void bubbleSort(Integer[] array)
    {
        boolean exchange = true;

        Integer temp;

        while(exchange == true)
        {
            exchange = false;
            for(int k = 0; k < array.length - 1; k++)
            {
                if(array[k].compareTo(array[k + 1]) > 0)
                {
                    exchange = true;
                    temp = array[k];
                    array[k] = array[k + 1];
                    array[k + 1] = temp;
                }
            }
        }
    }

    /**
     *
     * @param array Integer array that is populated with random values
     */
    public static void populateArray(Integer[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            array[i] = (int)(Math.random() * 500 + 1);
        }
    }

    /**
     *
     * @param array Integer array that is iterated over and has its elements displayed
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
