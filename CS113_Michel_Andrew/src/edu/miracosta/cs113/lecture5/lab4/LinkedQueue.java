package edu.miracosta.cs113.lecture5.lab4;

/**
 * Created by Andrew Michel on 2/27/2017.
 * Queue delegated with a Doubly-LinkedList
 */

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedQueue<E>
{
    private LinkedList<E> que;

    public LinkedQueue()
    {
        que = new LinkedList<E>();
    }

    /**
     * Inserts item at the rear of the queue.  Returns true if
     * successful; returns false if the item could not be inserted
     * @param data
     * @return
     */
    public boolean offer(E data)
    {
        que.addLast(data);

        if(que.peekLast().equals(data))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Removes the entry at the front of the queue and returns it if
     * the queue is not empty.  If the queue is empty,
     * throws a NoSuchElementException
     * @return
     */
    public E remove()
    {
        return null;
    }

    /**
     * Removes the entry at the front of the queue and returns it;
     * returns null if the queue is empty
     * @return
     */
    public E poll()
    {
        return null;
    }


    /**
     * Returns the entry at the front of the queue without
     * removing it; returns null if the queue is empty
     * @return
     */
    public E peek()
    {
        return null;
    }

    /**
     * Returns the entry at the front of the queue without removing it.
     * If the queue is empty, throws a NoSuchElementException
     * @return
     */
    public E element()
    {
        return null;
    }


}
