package edu.miracosta.cs113.hw6.project1;

/**
 * Created by Andrew Michel on 3/11/2017.
 *
 * 'Stub' class which is used to simulate a single piece of page
 */
public class Page
{
    String contents;

    public Page()
    {
        contents = "vanity";
    }

    public Page(String contents)
    {
        this.contents = contents;
    }

    public String getContents()
    {
        return contents;
    }

    public void setContents(String contents)
    {
        this.contents = contents;
    }

    /**
     *
     * @return String containing contents
     */
    public String toString()
    {
        return contents;
    }
}
