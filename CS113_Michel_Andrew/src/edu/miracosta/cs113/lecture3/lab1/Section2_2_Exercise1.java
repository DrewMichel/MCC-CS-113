package edu.miracosta.cs113.lecture3.lab1;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by W7237616 on 2/6/2017.
 */
public class Section2_2_Exercise1
{
    private ArrayList<DirectoryEntry> directoryArrayList;

    /**
     * Add an entry to theDirectory or change an existing entry
     * @param aName The name of the person being added or changed
     * @param newNumber The new number to be assigned
     * @return The old number, or if a new entry, null
     */
    public String addOrChangeEntry(String aName, String newNumber)
    {
        ListIterator<DirectoryEntry> iterator = directoryArrayList.listIterator();

        DirectoryEntry currentEntry = null;

        String previousName = null, previousNumber = null;

        boolean added = false;

        while(iterator.hasNext() && added == false)
        {
            currentEntry = iterator.next();

            previousName = currentEntry.getName();

            previousNumber = currentEntry.getNumber();

            if(previousName.equals(aName))
            {
                iterator.set(new DirectoryEntry(aName, newNumber));
                added = true;
            }
        }

        if(added == false)
        {
            directoryArrayList.add(new DirectoryEntry(aName, newNumber));
        }

        return previousNumber;
    }
}
