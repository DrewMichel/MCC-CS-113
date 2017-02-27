package edu.miracosta.cs113.hw3.project1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Andrew Michel on 2/14/2017.
 * Replaces LinkedList version
 */
public class Chapter2_Project1<T>
{
    private int capacity;
    private T[] aList;
    private int size;

    public Chapter2_Project1()
    {
        size = 0;
        capacity = 10;
        aList = (T[]) new Object[capacity];
    }

    public Chapter2_Project1(int capacity)
    {
        size = 0;
        this.capacity = capacity;
        aList = (T[]) new Object[capacity];
    }

    private void reallocate ()
    {
        capacity *= 2;
        aList = Arrays.copyOf(aList, capacity);
    }

    public boolean add(T item)
    {
        add(size, item);
        return true;
    }


    // Project methods

    /**
     * Add a new assignment
     */

    public void add(int index, T anEntry)
    {
        // check bounds
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        // Make sure there is room
        if (size >= capacity) {
            reallocate();
        }

        // shift data
        for (int i = size; i > index; i--) {
            aList[i] = aList[i-1];
        }

        // insert item
        aList[index] = anEntry;
        size++;
    }

    /**
     *  Remove an assignment
     *  @return the element removed
     */

    public T remove(T item)
    {
        T removed = null;
        int index = -1;

        for(int i = 0; i < size; i++)
        {
            if(aList[i] != null)
            {
                if(aList[i].equals(item))
                {
                    //aList[i] = null;
                    index = i;
                    break;
                }
            }
        }

        if(index > -1)
        {
            for(int i = index + 1; i < size; i++)
            {
                aList[i-1] = aList[i];
            }

            size--;
            aList[size] = null;
        }

        return removed;
    }


    /**
     * Provide a list of the assignments in the order they were assigned
     * @return an ArrayList sorted by ascending assignmentNumber
     */

    public ArrayList<T> getOrderedList()
    {
        T[] copy = (T[]) new Object[capacity];
        ArrayList<T> base = new ArrayList<T>(capacity);

        int indexPosition = 0;
        int lowestNumber = Integer.MAX_VALUE;
        int iterations = 0;

        boolean clear = false;

        Assignment temp = null;

        for(int i = 0; i < capacity; i++)
        {
            if(aList[i] != null)
            {
                copy[i] = aList[i];
            }
        }

        // Finds lowest assignment number
        while(clear == false)
        {
            lowestNumber = Integer.MAX_VALUE;
            iterations = 0;

            clear = true;

            while(iterations < capacity)
            {
                if(copy[iterations] != null)
                {
                    temp = (Assignment) copy[iterations];

                    if(temp.getAssignmentNumber() < lowestNumber)
                    {
                        lowestNumber = temp.getAssignmentNumber();
                        indexPosition = iterations;
                        clear = false;
                    }
                }

                iterations++;
            }

            if(clear == false)
            {
                if(copy[indexPosition] != null)
                {
                    base.add(copy[indexPosition]);
                }

                copy[indexPosition] = null;
            }
        }

        return base;
    }

    /**
     * Prints the assignment(s) with the earliest due date
     */

    public void printUpcoming()
    {
        Assignment temp = null;
        Assignment base = null;

        boolean firstAdd = true;

        // Finds earliest due date assignment
        for(int i = 0; i < aList.length; i++)
        {
            if(aList[i] != null && firstAdd == true)
            {
                firstAdd = false;
                base = (Assignment) aList[i];
            }
            else if(aList[i] != null)
            {
                temp = (Assignment) aList[i];

                if(base.compareTo(temp) == 1)
                {
                    base = temp;
                }
            }
        }

        for (int i = 0; i < aList.length; i++)
        {
            if(aList[i] != null)
            {
                temp = (Assignment) aList[i];

                if(base.compareTo(temp) == 0)
                {
                    System.out.println(temp.toString());
                }
            }
        }
    }

    public int size()
    {
        return size;
    }

}
