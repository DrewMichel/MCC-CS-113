package edu.miracosta.cs113.hw006.project1;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

/**
 * Created by Andrew Michel on 3/11/2017.
 *
 * This class acts as an Office which can house several printers and process printjobs through the printers
 */
public class Office
{
    private static int printerAssignmentID = 1;
    private static int officeAssignmentID = 1;

    private ArrayList<Printer> printers;

    private Queue<PrintJob> smallQueue;
    private Queue<PrintJob> mediumQueue;
    private Queue<PrintJob> largeQueue;

    private Calendar timeCompleted;
    private Calendar currentTime;

    private int numberOfPrinters, officeID, orderOutput;

    public Office()
    {
        printers = new ArrayList<>();

        smallQueue = new LinkedList<>();
        mediumQueue = new LinkedList<>();
        largeQueue = new LinkedList<>();

        numberOfPrinters = 1;
        officeID = officeAssignmentID++;
        orderOutput = 0;

        currentTime = new GregorianCalendar();
        timeCompleted = null;

        populatePrinters();
    }

    public Office(int capacity)
    {
        printers = new ArrayList<>(capacity);

        smallQueue = new LinkedList<>();
        mediumQueue = new LinkedList<>();
        largeQueue = new LinkedList<>();

        numberOfPrinters = capacity;
        officeID = officeAssignmentID++;
        orderOutput = 0;

        timeCompleted = null;
        currentTime = new GregorianCalendar();

        populatePrinters();
    }



    public Calendar getTimeCompleted()
    {
        return timeCompleted;
    }

    public void setTimeCompleted(long timeCompleted, boolean force)
    {
        if(this.timeCompleted == null || force == true)
        {
            this.timeCompleted = new GregorianCalendar();
            this.timeCompleted.setTimeInMillis(timeCompleted);
        }
    }

    public void setTimeCompleted(Calendar timeCompleted, boolean force)
    {
        if(this.timeCompleted == null || force == true)
        {
            this.timeCompleted = new GregorianCalendar();
            this.timeCompleted.setTimeInMillis(timeCompleted.getTimeInMillis());
        }
    }

    public Calendar getCurrentTime()
    {
        return currentTime;
    }

    public void setCurrentTime(Calendar currentTime)
    {
        this.currentTime = new GregorianCalendar();
        this.currentTime.setTimeInMillis(currentTime.getTimeInMillis());
    }

    /**
     *
     * @param quota the number of printjobs that printers in the office must complete
     * @return true if this office has met or surpassed its quota, else false
     */
    public boolean hasFinished(int quota)
    {
        if(orderOutput >= quota)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public int getOfficeID()
    {
        return officeID;
    }

    public void setOfficeID(int officeID)
    {
        this.officeID = officeID;
    }

    public int getOrderOutput()
    {
        return orderOutput;
    }

    public void setOrderOutput(int orderOutput)
    {
        this.orderOutput = orderOutput;
    }

    public ArrayList getPrinters()
    {
        return printers;
    }

    public int getNumberOfPrinters()
    {
        return numberOfPrinters;
    }

    public void setNumberOfPrinters(int numberOfPrinters)
    {
        this.numberOfPrinters = numberOfPrinters;
    }

    /**
     * Initializes Printer objects in printers ArrayList
     * @return true if population was successful, else false
     */
    public boolean populatePrinters()
    {
        boolean populated = false;

        printers.clear();

        for(int i = 0; i < numberOfPrinters; i++)
        {
            printers.add(new Printer(printerAssignmentID++));
        }

        return populated;
    }

    /**
     *
     * @param job PrintJob which is added to smallQueue if it has 10 or under pages,
     *            mediumQueue if it has 20 to 11 pages,
     *            or largeQueue if it has 21 to 50 pages
     * @return true if param was added to any queue, else false
     */
    public boolean addPrintJobToQueue(PrintJob job)
    {
        if(job.getPages().size() > 0 && job.getPages().size() < 11)
        {
            smallQueue.add(job);
            return true;
        }
        else if(job.getPages().size() > 10 && job.getPages().size() < 21)
        {
            mediumQueue.add(job);
            return true;
        }
        else if(job.getPages().size() > 20 && job.getPages().size() < 51)
        {
            largeQueue.add(job);
            return true;
        }
        return false;
    }

    /**
     * Iterates through Printers in printers ArrayList and attempts to pop a PrintJob
     * from the smallQueue, mediumQueue, or largeQueue, in that order, to an available printer
     * @return true if a printer received a new PrintJob, else false
     */
    public boolean processPrintJob()
    {
        ListIterator iterator = printers.listIterator();

        Printer temp = null;

        boolean added = false;

        // Iterators through printers
        while(iterator.hasNext())
        {
            temp = (Printer) iterator.next();

            if(temp != null && temp.getCurrentJob() == null)
            {
                if(smallQueue.peek() != null)
                {
                    added = true;
                    temp.setCurrentJob(smallQueue.poll());
                }
                else if(mediumQueue.peek() != null)
                {
                    added = true;
                    temp.setCurrentJob(mediumQueue.poll());
                }
                else if(largeQueue.peek() != null)
                {
                    added = true;
                    temp.setCurrentJob(largeQueue.poll());
                }
            }
        }

        return added;
    }

    /**
     * Iterates over the Printers in printers ArrayList displays information related to completed PrintJobs
     * Responsible for updating the Office's time of job completions and quota completion
     * @param pagesPerMinute the number of pages which can be printed per minute
     * @return
     */
    public boolean printPages(int pagesPerMinute)
    {
        long endTime = currentTime.getTimeInMillis();

        // Per printer not total
        int numberOfPagesPrinted = 0;

        ListIterator iterator;

        Printer temp = null;

        while(numberOfPagesPrinted < pagesPerMinute)
        {
            iterator = printers.listIterator();

            while(iterator.hasNext())
            {
                temp = (Printer) iterator.next();

                // Loads printjob if printer is empty or becomes empty
                if(temp != null && temp.getCurrentJob() == null)
                {
                    processPrintJob();
                }

                if(temp != null && temp.getCurrentJob() != null)
                {
                    if(temp.getCurrentJob().getPages().size() == 1)
                    {
                        // 60,000 milliseconds / pagesPerMinute (10) = 6,000... 6 seconds
                        currentTime.setTimeInMillis(currentTime.getTimeInMillis() + (( numberOfPagesPrinted) * (60000 / pagesPerMinute)));

                        System.out.println(temp.getCurrentJob().toString());
                        System.out.println("COMPLETED: #" + ++orderOutput + " | ON: "  + currentTime.getTime() + " | BY: " + temp.toString() + " | IN: " + toString() + "\n");
                        temp.setCurrentJob(null);

                        if(hasFinished(100) == true)
                        {
                            //setTimeCompleted(currentTime, false);
                            setTimeCompleted(currentTime.getTimeInMillis() + ((1 + numberOfPagesPrinted) * (60000) / pagesPerMinute), false);
                        }
                    }
                    else if (temp.getCurrentJob().getPages().size() > 1)
                    {
                        temp.getCurrentJob().getPages().remove(temp.getCurrentJob().getPages().size() - 1);
                        //System.out.println("NUMBER OF PAGES LEFT: " + temp.getCurrentJob().getPages().size() + " " + temp.toString());
                    }
                }
            }

            numberOfPagesPrinted++;

            //System.out.println("NUMBER OF PAGES PRINTED: " + numberOfPagesPrinted);
        }

        endTime = endTime + (10) * (60000 / pagesPerMinute);

        currentTime.setTimeInMillis(endTime);

        return false;
    }


    /**
     *
     * @return String containing this office's ID number and the number of printers in this office
     */
    public String toString()
    {
        return "Office #" + officeID + " has " + numberOfPrinters + " printers";
    }
}
