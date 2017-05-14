package edu.miracosta.cs113.hw013.project1.studentcode;

import java.util.Iterator;

// Insert solution to programming project 1, chapter -1 here
public class MatrixGraph extends AbstractGraph
{
    private double[][] edges;



    public MatrixGraph(int numV, boolean isDirected)
    {
        super(numV, isDirected);


    }

    @Override
    public void insert(Edge edge)
    {

    }

    @Override
    public boolean isEdge(int source, int dest)
    {
        return false;
    }

    @Override
    public Edge getEdge(int source, int dest)
    {
        return null;
    }

    @Override
    public Iterator<Edge> edgelterator(int source)
    {
        return null;
    }
}

