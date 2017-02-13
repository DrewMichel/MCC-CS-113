package edu.miracosta.cs113.lecture3.lab1.project2;

/**
 * Created by Andrew Michel on 2/6/2017.
 */

/**
 * DirectoryEntry class from textbook
 */
public class DirectoryEntry
{
    // Instance variables
    private String number;
    private String name;

    // Constructors
    public DirectoryEntry()
    {
        number = "0000";
        name = "John Doe";
    }

    public DirectoryEntry(String num, String nam)
    {
        number = num;
        name = nam;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * basic toString override.  Nothing to see here, move along.
     * Not the droids you're looking for.
     * @return a String containing DirectoryEntry name and number
     */
    public String toString()
    {
        return "Name: " + name + " Number: " + number;
    }

    /**
     * Compares the names of two DirectoryEntry objects to return true,
     * does not compare numbers
     * @param o any Object
     * @return true if equal, else false
     */
    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        if(o.getClass() != this.getClass())
        {
            return false;
        }

        DirectoryEntry temp = (DirectoryEntry) o;

        if(temp.getName().equals(this.getName()))
        {
            return true;
        }

        return false;
    }
}
