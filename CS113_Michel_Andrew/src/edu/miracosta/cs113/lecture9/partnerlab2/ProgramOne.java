package edu.miracosta.cs113.lecture9.partnerlab2;

import java.util.HashMap;

/**
 * Created by Andrew Michel on 4/16/2017.
 *
 * 1. Code the following algorithm for finding the location of an object as a static method.
 *      Assume a hash table array and an object to be located in the table are passed as arguments.
 *      Return the object's position if it is found; return -1 if the object is not found.
 *      1. Compute the index by taking the hashCode() % table.length.
 *      2. if table[index] is null
 *      3. The object is not in the table.
 *      else if table[index] is equal to the object
 *      4. The object is in the table.
 *      else
 *      5. Continue to search the table (by incrementing index) until either the
 *      object is found or a null entry is found.
 */
public class ProgramOne
{
    /**
     *
     * @param hashArray the array that is searched for the object
     * @param search the object that is searched for within the array
     * @return position the position in the array that the object was found at,
     *          or -1 if the object was not found
     */
    public int locateObject(Object[] hashArray, Object search)
    {
        int position = -1;
        int code = search.hashCode() % hashArray.length;
        int currentPoint = code;
        boolean firstRun = true;
        boolean found = false;

        if(hashArray[code] == null)
        {
            position = -1;
        }
        else if(hashArray[code].equals(search))
        {
            position = code;
        }
        else
        {
            while((found == false && hashArray[currentPoint] != null && currentPoint != code) || firstRun == true)
            {
                firstRun = false;

                if(hashArray[currentPoint].equals(search))
                {
                    found = true;
                    position = currentPoint;
                }
                else
                {
                    currentPoint = (currentPoint + 1) % hashArray.length;
                }
            }
        }

        return position;
    }
}
