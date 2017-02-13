package edu.miracosta.cs113.lecture3.lab1.project1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Andrew Michel on 2/6/2017.
 */



public class Section2_1_Exercise2
{

    /**
     * Deletes the first occurrence of target in aList.
     */
    public static void delete(ArrayList<String> aList, String target)
    {
        Iterator<String> iterator = aList.iterator();

        boolean deleted = false;

        while(iterator.hasNext() && deleted == false)
        {

            if(iterator.next().equals(target))
            {
                iterator.remove();
                deleted = true;
            }
        }
    }
}
