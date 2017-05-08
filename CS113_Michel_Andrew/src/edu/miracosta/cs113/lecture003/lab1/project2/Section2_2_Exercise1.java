package edu.miracosta.cs113.lecture003.lab1.project2;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by Andrew Michel on 2/6/2017.
 */
public class Section2_2_Exercise1
{
    private ArrayList<DirectoryEntry> theDirectory;

    // Default constructor
    public Section2_2_Exercise1()
    {
        theDirectory = new ArrayList<DirectoryEntry>();
    }

    public Section2_2_Exercise1(int capacity)
    {
        theDirectory = new ArrayList<DirectoryEntry>(capacity);
    }

    /**
     * Add an entry to theDirectory or change an existing entry
     * @param aName The name of the person being added or changed
     * @param newNumber The new number to be assigned
     * @return The old number, or if a new entry, null
     */
    public String addOrChangeEntry(String aName, String newNumber)
    {
        ListIterator<DirectoryEntry> iterator = theDirectory.listIterator();

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
                iterator.set(new DirectoryEntry(newNumber, aName));
                added = true;
            }
        }

        if(added == false)
        {
            theDirectory.add(new DirectoryEntry(newNumber, aName));
        }

        return previousNumber;
    }

    // Section2_2_Exercise2 method

    /**
     * Remove an entry
     * @param aName The name of the person being removed
     * @return The entry being removed, or null if there is no entry for aName
     * CHANGED: Entry return to DirectoryEntry
     */
    public DirectoryEntry removeEntry(String aName)
    {
        DirectoryEntry removedEntry = null;

        int index = -1;

        index = theDirectory.indexOf(new DirectoryEntry("", aName));

        if(index != -1)
        {
            removedEntry = theDirectory.get(index);

            theDirectory.remove(index);
        }

        return removedEntry;
    }

    /**
     * Iterates through theDirectory instance variable and prints all entries
     */
    public void displayEntries()
    {
        ListIterator<DirectoryEntry> iterator = theDirectory.listIterator();

        while(iterator.hasNext())
        {
            System.out.println(iterator.next().toString());
        }
    }

}
