package edu.miracosta.cs113.hw6.project1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ListIterator;

/**
 * Created by Andrew Michel on 3/11/2017.
 *
 * This class can store pages in an ArrayList, record the time the printjob was created,
 * the original size of the order, and an order ID which can be to keep track of the job.
 */
public class PrintJob
{
    private ArrayList<Page> pages;
    private Calendar orderTime;
    private int orderSize;
    private int orderID;

    public PrintJob()
    {
        pages = new ArrayList<>();
        orderTime = new GregorianCalendar();
        orderSize = 0;
        orderID = 0;

        populatePages();
    }

    public PrintJob(int capacity)
    {
        pages = new ArrayList<>(capacity);
        orderTime = new GregorianCalendar();
        orderSize = capacity;
        orderID = 0;

        populatePages();
    }

    public PrintJob(int capacity, Calendar orderTime, int orderID)
    {
        pages = new ArrayList<>(capacity);
        this.orderTime = new GregorianCalendar();
        this.orderTime.setTimeInMillis(orderTime.getTimeInMillis());
        orderSize = capacity;
        this.orderID = orderID;

        populatePages();
    }

    // Copy constructor
    public PrintJob(PrintJob otherJob)
    {
        this.orderID = otherJob.orderID;
        this.orderTime = new GregorianCalendar();
        this.orderTime.setTimeInMillis(otherJob.getOrderTime().getTimeInMillis());
        this.pages = otherJob.getPagesCopy();
    }

    /**
     * Initializes the pages ArrayList with Page objects
     * @return true if pages were added, else false
     */
    public boolean populatePages()
    {
        boolean added = false;

        pages.clear();

        for(int i = 0; i < orderSize; i++)
        {
            pages.add(new Page());
            added = true;
        }

        return added;
    }

    /**
     *
     * @return copy a deep copy of the pages ArrayList instance variable
     */
    public ArrayList<Page> getPagesCopy()
    {
        ListIterator iterator = pages.listIterator();

        ArrayList<Page> copy = new ArrayList<>(pages.size());

        while(iterator.hasNext())
        {
            copy.add((Page) iterator.next());
        }

        return copy;
    }

    public ArrayList<Page> getPages()
    {
        return pages;
    }

    public Calendar getOrderTime()
    {
        return orderTime;
    }

    public void setOrderTime(Calendar orderTime)
    {
        this.orderTime = orderTime;
    }

    public int getOrderSize()
    {
        return orderSize;
    }

    public void setOrderSize(int orderSize)
    {
        this.orderSize = orderSize;
    }

    /**
     *
     * @return String containing the printjob ID, original size, and time created.
     */
    public String toString()
    {
        return "PrintJob #" + orderID + " with " + orderSize + " pages issued: " + orderTime.getTime();
    }
}
