package edu.miracosta.cs113.lecture5.lab2;

/**
 * Created by w7237616 on 2/27/2017.
 */

import java.util.EmptyStackException;
import java.util.ArrayList;

public class ReverseStack<E>
{
    private static final int INITIAL_CAPACITY = 10;

    private ArrayList<E> dataList;

    public ReverseStack()
    {
        dataList = new ArrayList<E>(INITIAL_CAPACITY);
    }

    /**
     *
     * @param data added on top of stack
     * @return data that was added on top of stack
     */
    public E push(E data)
    {
        dataList.add(data);

        return data;
    }

    /**
     *
     * @return data removed from the top of the stack
     * @throws EmptyStackException if no data is in the stack
     */
    public E peek()
    {
        if(empty() == true)
        {
            throw new EmptyStackException();
        }
        else
        {
            return dataList.get(dataList.size() - 1);
        }
    }

    /**
     *
     * @return data removed from the top of the stack
     * @throws EmptyStackException if no data is in the stack
     */
    public E pop()
    {
        if(empty() == true)
        {
            throw new EmptyStackException();
        }
        else
        {
            return dataList.remove(dataList.size() - 1);
        }
    }

    /**
     *
     * @return true if the stack is empty, else false
     */
    public boolean empty()
    {
        return dataList.size() == 0;
    }
}