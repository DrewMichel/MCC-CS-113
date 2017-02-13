package edu.miracosta.cs113.hw3.project1;

/**
 * Created by Andrew Michel on 2/13/2017.
 */
public class Assignment implements Comparable<Assignment>
{
    private int yearDue, monthDue, dayDue;

    private int yearAssigned, monthAssigned, dayAssigned;

    private String className, assignmentName;

    public Assignment()
    {
        this.yearDue = 0;
        this.monthDue = 0;
        this.dayDue = 0;

        this.yearAssigned = 0;
        this.monthAssigned = 0;
        this.dayAssigned = 0;

        this.className = "CS130";
        this.assignmentName = "project0";
    }

    public Assignment(String className, String assignmentName, int yearAssigned, int monthAssigned, int dayAssigned, int yearDue, int monthDue, int dayDue)
    {
        this.yearDue = yearDue;
        this.monthDue = monthDue;
        this.dayDue = dayDue;

        this.yearAssigned = yearAssigned;
        this.monthAssigned = monthAssigned;
        this.dayAssigned = dayAssigned;

        this.className = className;
        this.assignmentName = assignmentName;
    }

    public int getYearDue()
    {
        return yearDue;
    }

    public void setYearDue(int yearDue)
    {
        this.yearDue = yearDue;
    }

    public int getMonthDue() {
        return monthDue;
    }

    public void setMonthDue(int monthDue)
    {
        this.monthDue = monthDue;
    }

    public int getDayDue()
    {
        return dayDue;
    }

    public void setDayDue(int dayDue)
    {
        this.dayDue = dayDue;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public int getYearAssigned()
    {
        return yearAssigned;
    }

    public void setYearAssigned(int yearAssigned)
    {
        this.yearAssigned = yearAssigned;
    }

    public int getMonthAssigned() {
        return monthAssigned;
    }

    public void setMonthAssigned(int monthAssigned)
    {
        this.monthAssigned = monthAssigned;
    }

    public int getDayAssigned()
    {
        return dayAssigned;
    }

    public void setDayAssigned(int dayAssigned)
    {
        this.dayAssigned = dayAssigned;
    }

    /**
     *
     * @return a String containing the assignmentName, className, and due date values
     */
    public String toString()
    {
        return String.format("Assignment %s for the class %s is due %d//%d//%d", assignmentName, className, monthDue, dayDue, yearDue);
    }

    /**
     *
     * @param o Object compared to this
     * @return true if className and assignmentName are the same, else false
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

        Assignment temp = (Assignment) o;

        if(temp.className.equals(this.className) && temp.equals(assignmentName))
        {
            return true;
        }

        return false;
    }

    /**
     *
     * @param o Assignment object that is compared to this
     * @return -1 if this is less than parameter, 0 if equal to parameter, or 1 if greater than parameter
     */
    @Override
    public int compareTo(Assignment o)
    {
        // -1 less than parameter
        // 0 equal to parameter
        // 1 greater than parameter
        if(this.yearDue < o.yearDue)
        {
            return -1;
        }
        else if(this.yearDue == o.yearDue && this.monthDue < o.monthDue)
        {
            return -1;
        }
        else if(this.yearDue == o.yearDue && this.monthDue == o.monthDue && this.dayDue < o.dayDue)
        {
            return -1;
        }
        else if(this.yearDue == o.yearDue && this.monthDue == o.monthDue && this.dayDue == o.dayDue)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
}
