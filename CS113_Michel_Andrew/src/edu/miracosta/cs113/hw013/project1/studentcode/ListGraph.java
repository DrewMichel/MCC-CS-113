package edu.miracosta.cs113.hw013.project1.studentcode;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Andrew Michel on 5/12/2017.
 */
public class ListGraph
{
    private List<Edge>[] edges;

    /** The number of vertices */
    private int numV;
    /** Flag to indicate whether this is a directed graph */
    private boolean directed;

    public ListGraph(int numV, boolean isDirected)
    {
        this.numV = numV;

        this.directed = isDirected;

        edges = new List[numV];

        for(int i = 0; i < numV; i++)
        {
            edges[i] = new LinkedList<Edge>();
        }
    }

    //@Override
    public void insert(Edge edge)
    {
        edges[edge.getSource()].add(edge);

        if(!isDirected())
        {
            edges[edge.getDest()].add(new Edge(edge.getDest(), edge.getSource(), edge.getWeight()));
        }
    }

    public int getNumV() {
        return numV;
    }

    /**
     * Return whether this is a directed graph.
     * @return true if this is a directed graph
     */
    //@Override
    public boolean isDirected() {
        return directed;
    }

    //@Override
    public boolean isEdge(int source, int dest)
    {
        return edges[source].contains(new Edge(source, dest));
    }

    //@Override
    public Edge getEdge(int source, int dest)
    {
        Edge target = new Edge(source, dest, Double.POSITIVE_INFINITY);

        for(Edge edge : edges[source])
        {
            if(edge.equals(target))
            {
                return edge;
            }
        }

        return target;
    }

    public Iterator<Edge> edgelterator(int source)
    {
        return edges[source].iterator();
    }

    /**
     *
     * @param scan Scanner used to read edge information from file
     */
    public void loadEdgesFromFile(Scanner scan)
    {
        String[] splitLine = null;

        int previous = 0, current = 0;

        double distance = 0;

        while(scan.hasNextLine())
        {
            splitLine = scan.nextLine().replaceAll("\\s+", " ").trim().split(" ");

            previous = Integer.parseInt(splitLine[0]);

            current = Integer.parseInt(splitLine[1]);

            if(splitLine.length > 2)
            {
                distance = Double.parseDouble(splitLine[2]);
            }

            this.insert(new Edge(previous, current, distance));
        }
    }

    public static ListGraph createGraph(Scanner scan,
                                    boolean isDirected,
                                    String type) throws IOException {
        int numV = scan.nextInt();
        scan.nextLine();
        ListGraph returnValue = null;
        if (type.equalsIgnoreCase("List"))
        {
            returnValue = new ListGraph(numV, isDirected);
        }
        else
        {
            throw new IllegalArgumentException();
        }
        returnValue.loadEdgesFromFile(scan);
        return returnValue;
    }
}
