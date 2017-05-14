package edu.miracosta.cs113.hw013.project1;

/**
 * Created by Andrew Michel on 5/12/2017.
 *
 * Uses dijkstra's algorithm within textbook find best paths to vertices using edges
 */
import edu.miracosta.cs113.hw013.project1.studentcode.Edge;
import edu.miracosta.cs113.hw013.project1.studentcode.ListGraph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Iterator;

public class Driver
{
    private static final boolean DIRECTED_DEFAULT = false;
    private static final String MATRIX_TYPE = "List";

    public static void main(String[] args)
    {
        Scanner reader = null;
        Scanner keyboard = new Scanner(System.in);

        ListGraph graph = null;

        double[] distArray;
        int[] predArray;

        int startVertex = 0;
        boolean primed = false;
        String userInput = null;

        try
        {
            // File must exist in top project directory
            reader = new Scanner(new FileInputStream("matrixlist.txt"));

            primed = true;

            graph = ListGraph.createGraph(reader, DIRECTED_DEFAULT, MATRIX_TYPE);
        }
        catch(FileNotFoundException e)
        {
        }
        catch(IOException e)
        {
        }

        try
        {
            if(primed == false)
            {
                // File must exist in top project directory
                System.out.print("ENTER FILE NAME: ");

                userInput = keyboard.nextLine();

                reader = new Scanner(new FileInputStream(userInput));

                graph = ListGraph.createGraph(reader, DIRECTED_DEFAULT, MATRIX_TYPE);
            }
        }
        catch(InputMismatchException e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("How did you do that with a String?!");
            System.exit(0);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.exit(0);
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.exit(0);
        }


        distArray = new double[graph.getNumV()];

        predArray = new int[graph.getNumV()];

        dijkstrasAlgorithm(graph, startVertex, predArray, distArray);

        System.out.println("\nDISPLAYING ORIGINAL DIJKSTRA VERTICES");

        for(int i = 0; i < graph.getNumV(); i++)
        {
            System.out.println("VERTEX " + i + " PREDECESSOR " + predArray[i] + " DISTANCE " + distArray[i]);
        }

        if(reader != null)
        {
            reader.close();
        }
    }

    /** Dijkstra's Shortest-Path algorithm chapter 10 page 583
        @param graph The weighted graph to be searched
        @param start The start vertex
        @param pred Output array to contain the predecessors
        in the shortest path
        @param dist Output array to contain the distance
        in the shortest path
     */
    public static void dijkstrasAlgorithm(ListGraph graph, int start, int[] pred, double[] dist)
    {
        int numV = graph.getNumV();

        HashSet<Integer> vMinusS = new HashSet<>(numV);

        PriorityQueue<Edge> queue = new PriorityQueue<>(numV);

        // Initialize V-S
        for(int i = 0; i < numV; i++)
        {
            if(i != start)
            {
                vMinusS.add(i);
            }
        }

        // Initialize pred and dist
        for(int v : vMinusS)
        {
            pred[v] = start;
            dist[v] = graph.getEdge(start, v).getWeight();
        }

        // Main loop
        while(vMinusS.size() > 0)
        {
            // Find the value u in V-S with the smallest dist[u]
            double minDist = Double.POSITIVE_INFINITY;

            int u = -1;

            for(int v : vMinusS)
            {
                if(dist[v] < minDist)
                {
                    minDist = dist[v];
                    u = v;
                }
            }

            // Remove u from vMinusS
            vMinusS.remove(u);

            // Update the distances ListGraph
            Iterator<Edge> iterator = graph.edgelterator(u);

            while(iterator.hasNext())
            {
                Edge edge = iterator.next();

                int v = edge.getDest();

                if(vMinusS.contains(new Integer(v)))
                {
                    double weight = edge.getWeight();

                    if(dist[u] + weight < dist[v])
                    {
                        dist[v] = dist[u] + weight;
                        pred[v] = u;


                    }
                }
            }

            // Update the distances MatrixGraph
            /*
            for(int v : vMinusS)
            {
                if(graph.isEdge(u, v))
                {
                    double weight = graph.getEdge(u, v).getWeight();



                    if(dist[u] + weight < dist[v])
                    {

                        dist[v] = dist[u] + weight;

                        queue.add(new Edge(pred[v], u, dist[v]));

                        pred[v] = u;
                    }


                }
            }
            */
        }

        for(int i = 0; i < numV; i++)
        {
            if(i != start)
            {
                queue.add(new Edge(start, i, dist[i]));
            }
        }

        if(queue.isEmpty() == false)
        {
            System.out.println("DISPLAYING PRIORITY QUEUE DIJKSTRA VERTICES");
        }

        while(queue.isEmpty() == false)
        {
            System.out.println(queue.poll());
        }
    }

    /*
    // Original dijkstrasAlgorithm
    public static void dijkstrasAlgorithm(ListGraph graph, int start, int[] pred, double[] dist)
    {
        int numV = graph.getNumV();

        HashSet<Integer> vMinusS = new HashSet<>(numV);

        // Initialize V-S
        for(int i = 0; i < numV; i++)
        {
            if(i != start)
            {
                vMinusS.add(i);
            }
        }

        // Initialize pred and dist
        for(int v : vMinusS)
        {
            pred[v] = start;
            dist[v] = graph.getEdge(start, v).getWeight();
        }

        // Main loop
        while(vMinusS.size() > 0)
        {
            // Find the value u in V-S with the smallest dist[u]
            double minDist = Double.POSITIVE_INFINITY;

            int u = -1;

            for(int v : vMinusS)
            {
                if(dist[v] < minDist)
                {
                    minDist = dist[v];
                    u = v;
                }
            }

            // Remove u from vMinusS
            vMinusS.remove(u);

            // Update the distances
            for(int v : vMinusS)
            {
                if(graph.isEdge(u, v))
                {
                    double weight = graph.getEdge(u, v).getWeight();

                    if(dist[u] + weight < dist[v])
                    {
                        dist[v] = dist[u] + weight;

                        pred[v] = u;
                    }
                }
            }
        }
    }
     */
}
