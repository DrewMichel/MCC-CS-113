package edu.miracosta.cs113.lecture10.lab1;

/**
 * Created by w7237616 on 4/17/2017.
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
        boolean exchange = false;

        Integer temp;

        for(int i = 0; i < array.length && exchange == false; i++)
        {
            exchange = true;
            for(int k = 0; k < array.length; k++)
            {
                if(array[i].compareTo(array[k]) < 0)
                {
                    exchange = false;
                    temp = array[k];
                    array[k] = array[i];
                    array[i] = temp;
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
