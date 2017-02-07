package edu.miracosta.cs113.lecture3.lab1;

/**
 * Created by W7237616 on 2/6/2017.
 */

import java.util.ArrayList;
import java.util.ListIterator;

public class Section2_1_Exercise1
{

    /**
     * Replaces each occurrence of oldItem in aList with newItem.
     */
    public static void replace(ArrayList<String> aList, String oldItem, String newItem)
    {
        ListIterator<String> iterator = aList.listIterator();

        while(iterator.hasNext())
        {
            if(iterator.next().equals(oldItem))
            {
                iterator.set(newItem);
            }
        }
    }
}
