package edu.miracosta.cs113.lecture3.lab1;

/**
 * Created by W7237616 on 2/6/2017.
 */
public class DirectoryEntry
{
    private String number;

    private String name;

    public DirectoryEntry(String num, String nam)
    {
        number = number;

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

        if(temp.getName().equals(this.getName()) && temp.getNumber().equals(this.getNumber()))
        {
            return true;
        }

        return false;
    }
}
