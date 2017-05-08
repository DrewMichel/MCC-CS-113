package edu.miracosta.cs113.hw012.project1;

import edu.miracosta.cs113.hw012.project1.studentcode.SkipList;

/**
 * Created by Andrew Michel on 5/7/2017.
 *
 * Driver class that uses SkipLists
 */
public class Driver
{
    public static void main(String[] args)
    {
        SkipList<Integer> skipList = new SkipList<>();

        populateSkipList(skipList, 20);

        System.out.println("SKIPLIST WITH 20 ELEMENTS\n");

        skipList.displaySkipList();

        System.out.println("\nSKIPLIST WITH 16-20 REMOVED\n");

        deleteRangeFromSkipList(skipList, 16, 20);

        skipList.displaySkipList();
    }

    /**
     *
     * @param skipList skiplist that has elements inserted into it
     * @param elements range of numbers from 1 to elements that is inserted into skiplist
     */
    public static void populateSkipList(SkipList<Integer> skipList, int elements)
    {
        for(int i = 0; i < elements; i++)
        {
            skipList.add(i+1);
        }
    }

    /**
     *
     * @param skipList skiplist that has elements removed from it
     * @param min minimum range of elements that are removed
     * @param max maximum range of elements that are removed
     */
    public static void deleteRangeFromSkipList(SkipList<Integer> skipList, int min, int max)
    {
        for(int i = max; i >= min; i--)
        {
            skipList.remove(i);
        }
    }
}
