import java.util.ArrayList;

/**
 * Created by Andrew Michel on 2/13/2017.
 */
public class Chapter2_Project1<T extends Comparable>
{
    private Node<T> head;
    private int size;

    // Constructors
    public Chapter2_Project1()
    {
        head = null;
        size = 0;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    // Project methods

    /**
     * Add a new assignment
     */
    public void add(T data)
    {
       head = new Node<T> (head, data);
    }

    /**
     * Remove an assignment
     * @return the data inside the node that was removed
     */
    public T remove(T data)
    {
        Node<T> iterator = head;
        T removed = null;

        Assignment temp = null;
        Assignment temp2 = null;

        if (iterator != null)
        {
            if(iterator.getData().equals(data))
            {
                removed = iterator.getData();
                head = iterator.getLink();
                size--;
            }

            while(iterator.getLink() != null)
            {
                temp = (Assignment) iterator.getLink().getData();
                temp2 = (Assignment) data;

                if(temp.compareTo(temp2) == 0)
                {
                    removed = iterator.getLink().getData();
                    iterator.setLink(iterator.getLink().getLink());
                    size--;
                }
                else
                {
                    iterator = iterator.getLink();
                }
            }
        }

        return removed;
    }

    /**
     *
     * @return an ArrayList of the assignments in the order they were assigned
     */
    public ArrayList<T> getArrayList()
    {
        ArrayList<T> aList = new ArrayList<T>();

        ArrayList<T> tempList = new ArrayList<T>();

        Node<T> iterator = head;

        while(iterator != null)
        {
            tempList.add(iterator.getData());
            iterator = iterator.getLink();
        }

        for(int i = tempList.size() - 1; i >= 0; i--)
        {
            aList.add(tempList.get(i));
        }

        return aList;
    }

    /**
     * Find the assignment(s) with the earliest due date and prints
     */
    public void printUpcoming()
    {
        Node<T> iterator = head;
        Node<T> upcoming = head;

        while(iterator != null)
        {
            if(iterator.getData().compareTo(upcoming.getData()) == -1)
            {
                upcoming = iterator;

            }
            iterator = iterator.getLink();
        }

        iterator = head;

        while(iterator != null)
        {
            if(iterator.getData().compareTo(upcoming.getData()) == 0)
            {
                System.out.println(iterator.getData().toString());

            }
            iterator = iterator.getLink();
        }
    }


    // Inner class start
    private class Node<U extends Comparable>
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
