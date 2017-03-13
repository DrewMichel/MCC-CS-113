package edu.miracosta.cs113.hw6.project1;

/**
 * Created by Andrew Michel on 3/11/2017.
 */
public class Printer
{
    private boolean active;
    private PrintJob currentJob;
    private int printerID;

    public Printer()
    {
        active = true;
        currentJob = null;
        printerID = 0;
    }

    public Printer(boolean active)
    {
        this.active = active;
        currentJob = null;
        printerID = 0;
    }

    public Printer(int printerID)
    {
        this.active = true;
        currentJob = null;
        this.printerID = printerID;
    }

    public Printer(boolean active, int printerID)
    {
        this.active = active;
        currentJob = null;
        this.printerID = printerID;
    }

    public PrintJob getCurrentJob()
    {
        return currentJob;
    }

    public void setCurrentJob(PrintJob currentJob)
    {
        this.currentJob = currentJob;
    }

    public int getPrinterID() {
        return printerID;
    }

    public void setPrinterID(int printerID) {
        this.printerID = printerID;
    }

    /**
     *
     * @return String containg the printer ID
     */
    public String toString()
    {
        return "Printer #" + printerID;
    }
}
