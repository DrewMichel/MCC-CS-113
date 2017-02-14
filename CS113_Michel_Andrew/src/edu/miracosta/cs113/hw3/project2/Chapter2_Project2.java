package edu.miracosta.cs113.hw3.project2;

/**
 * Created by Andrew Michel on 2/13/2017.
 * Actually project 3 in textbook
 * Single linked list which can insert at start or end or remove from start or by name (equals)
 */
public class Chapter2_Project2<T>
{
    private Node<T> head;

    public Chapter2_Project2()
    {
        head = null;
    }

    // Project methods

    /**
     * add new student at end of list
     */

    public void insertAtEnd(T data)
    {
        Node<T> iterator = head;

        if(head == null)
        {
            insertAtStart(data);
        }
        else
        {
            while(iterator.getLink() != null)
            {
                iterator = iterator.getLink();
            }

            Node<T> temp = new Node<T>(null, data);

            iterator.setLink(temp);
        }
    }

    /**
     * add new student at start of list
     */

    public void insertAtStart(T data)
    {
        head = new Node<T>(head, data);
    }

    /**
     * remove student from start of list
     * @return the data contained in the removed node
     */

    public T removeFromStart()
    {
        T removed = null;

        if(head != null)
        {
            removed = head.getData();

            head = head.getLink();
        }

        return removed;
    }

    /**
     * remove student by name
     * @return the data contained in the removed node
     */

    public T removeByName(T data)
    {
        T removed = null;

        Node<T> iterator = head;
        Node<T> previous = head;

        if(head != null)
        {
            if(head.getData().equals(data))
            {
                head = head.getLink();
            }

            previous = head;
            iterator = previous.getLink();

            while(iterator != null)
            {
                if(iterator.getData().equals(data))
                {
                    previous.setLink(iterator.getLink());
                }

                previous = previous.getLink();
                iterator = previous.getLink();
            }
        }

        return removed;
    }

    /**
     * Iterates through nodes and prints data
     */
    public void printData()
    {
        Node<T> iterator = head;

        while(iterator != null)
        {
            System.out.println(iterator.getData());
            iterator = iterator.getLink();
        }
    }

    // Inner class start
    private class Node<U>
    {
        private Node<U> link;
        private U data;

        public Node()
        {
            link = null;
            data = null;
        }

        public Node(Node<U> link, U data)
        {
            this.link = link;
            this.data = data;
        }

        public Node<U> getLink()
        {
            return link;
        }

        public void setLink(Node<U> link)
        {
            this.link = link;
        }

        public U getData()
        {
            return data;
        }

        public void setData(U data)
        {
            this.data = data;
        }
    } // Inner class end
}
