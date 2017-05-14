package edu.miracosta.cs113.hw013.project1.studentcode;

// Insert solution to programming exercise 1, section 2, chapter 10 here
public class Edge implements Comparable
{
    private int dest;
    private int source;
    private double weight;

    /**
     *
     * @param source
     * @param dest
     */
    public Edge(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
        weight = 1.0;
    }

    /**
     *
     * @param source
     * @param dest
     * @param w
     */
    public Edge(int source, int dest, double w)
    {
        this.source = source;
        this.dest = dest;
        weight = w;
    }

    /**
     *
     * @return source the starting point of this edge
     */
    public int getSource()
    {
        return source;
    }

    /**
     *
     * @return dest the ending point of this edge
     */
    public int getDest()
    {
        return dest;
    }

    /**
     *
     * @return weight the cost of moving from source to dest
     */
    public double getWeight()
    {
        return weight;
    }


    /**
     *
     * @return String containing instance variables source, dest, and weight
     */
    public String toString()
    {
        return "SOURCE: " + source + " DESTINATION: " + dest + " WEIGHT: " + weight;
    }

    /**
     *
     * @param other Object that is checked for equivalence against this object
     * @return true if equal, else false
     */
    public boolean equals(Object other)
    {
        if(other == null)
        {
            return false;
        }
        if(this.getClass() != other.getClass())
        {
            return false;
        }

        Edge temp = (Edge) other;

        if(temp.getSource() == this.source && temp.getDest() == this.getDest())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     *
     * @return int hashcode
     */
    public int hashCode()
    {
        return dest + source;
    }


    /**
     *
     * @param other object that is compared agains this object
     * @return 1 if this is greater than parameter
     *         -1 if this is less than parameter
     *         0 if this is equal to parameter
     */
    public int compareTo(Object other)
    {
        Edge temp = (Edge) other;
        if(this.getWeight() > temp.getWeight())
        {
            return 1;
        }
        else if(this.getWeight() < temp.getWeight())
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}