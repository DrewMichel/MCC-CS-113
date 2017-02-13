package edu.miracosta.cs113.hw3.project1;

import java.util.ArrayList;

/**
 * Created by Andrew Michel on 2/13/2017.
 */
public class Chapter2_Project1<T extends Comparable>
{
    private Node<T> head;

    // Constructors
    public Chapter2_Project1()
    {
        head = null;
    }

    // Project methods

    // Add a new assignment
    public void add(T data)
    {
        Node<T> iterator = head;

        while(iterator != null)
        {
            iterator = iterator.link;
        }

        iterator = new Node<T> (iterator.link, data);
    }

    // Remove an assignment
    public T remove(T data)
    {
        Node<T> iterator = head;
        T removed = null;

        if (iterator != null)
        {
            if(iterator.getData().equals(data))
            {
                removed = iterator.getData();
                head = iterator.link;
            }

            while(iterator.link != null)
            {
                if(iterator.link.equals(data))
                {
                    removed = iterator.getLink().getData();
                    iterator.link = iterator.link.link;
                }
                else
                {
                    iterator = iterator.link;
                }
            }
        }

        return removed;
    }
    // Provide a list of the assignments in the order they were assigned
    public ArrayList<T> getArrayList()
    {
        ArrayList<T> aList = new ArrayList<T>();



        return aList;
    }
    // Find the assignment(s) with the earliest due date

    // Inner class start
    private class Node<T extends Comparable>
    {
        private Node link;
        private T data;

        public Node(Node link, T data)
        {
            this.link = link;
            this.data = data;
        }

        public Node<T> getLink()
        {
            return link;
        }

        public void setLink(Node link)
        {
            this.link = link;
        }

        public T getData()
        {
            return data;
        }

        public void setData(T data)
        {
            this.data = data;
        }
    } // Inner class end
}
