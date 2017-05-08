package edu.miracosta.cs113.hw004.project1;

/**
 * Created by Andrew Michel on 2/13/2017.
 *
 * Contains getters, setters, toString, and equals
 */
public class Student
{
    private String name;
    private String id;

    public Student()
    {
        name = "John Doe";
        id = "none";
    }

    public Student(String name, String id)
    {
        this.name = name;
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String toString()
    {
        return "Name: " + name + " ID: " + id;
    }

    /**
     *
     * @param o Object to compare to this object
     * @return true if both objects have same student name and id, else false
     */
    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }

        if(this.getClass() != o.getClass())
        {
            return false;
        }

        Student temp = (Student) o;

        if(temp.getName().equals(this.getName()))
        {
            return true;
        }

        return false;
    }
}
