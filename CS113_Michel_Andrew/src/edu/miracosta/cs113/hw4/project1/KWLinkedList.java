/*<listing chapter="2" section="8">*/
package edu.miracosta.cs113.hw4.project1;

import java.util.AbstractSequentialList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Class KWLinkedList implements a double linked list and
 * a ListIterator.
 * @author Koffman & Wolfgang
 **/
public class KWLinkedList<E> extends AbstractSequentialList<E> {
    // Data Fields

    /** A reference to the head of the list. */
    private Node<E> head = null;
    /** A reference to the end of the list. */
    private Node<E> tail = null;
    /** The size of the list. */
    private int size = 0;

    //Methods
// Insert solution to programming exercise 4, section 8, chapter 2 here
    // Page 121
    // Implement the KWLinkedList addFirst, addLast, getFirst, and getLast methods

    /**
     *
     * @param dataItem is the data inserted into a new node which becomes the head
     */
    public void addFirst(E dataItem)
    {
        Node<E> temp = new Node<E>(dataItem);

        if(head == null)
        {
            head = temp;
            head.next = tail;

            tail = temp;
        }
        else
        {
            head.prev = temp;

            temp.next = head;

            head = temp;
        }

        size++;
    }

    /**
     *
     * @param dataItem is the data inserted into a new node which becomes the tail
     */
    public void addLast(E dataItem)
    {
        Node<E> temp = new Node<E>(dataItem);

        if(head == null)
        {
            addFirst(dataItem);
        }
        else if(tail == null)
        {
            tail = temp;
            tail.prev = head;
        }
        else
        {
            tail.next = temp;

            temp.prev = tail;

            tail = temp;
        }

        size++;
    }

    /**
     *
     * @return the data contained inside the head node
     */
    public E getFirst()
    {
        if (head != null)
        {
            return head.data;
        }
        else
        {
            return null;
        }
    }

    /**
     *
     * @return the data contained inside the tail node
     */
    public E getLast()
    {
        if(tail != null)
        {
            return tail.data;
        }
        else
        {
            return null;
        }
    }

// Insert solution to programming exercise 3, section 8, chapter 2 here
    // Page 121
    // Implement the KWLinkedList listIterator and iterator methods

    /**
     *
     * @param index the beginning index position of the ListIterator
     * @return a KWListIter object with an index set to the parameter
     */
    public ListIterator<E> listIterator(int index)
    {
        return new KWListIter(index);
    }

    /**
     *
     * @return a KWListIter object with an index set to 0
     */
    @Override
    public Iterator<E> iterator()
    {
        return new KWListIter(0);
    }

    /**
     * Add an item at the specified index.
     * @param index The index at which the object is to be
     *        inserted
     * @param obj The object to be inserted
     * @throws IndexOutOfBoundsException if the index is out
     *         of range (i < 0 || i > size())
     */
    @Override
    public void add(int index, E obj) {
        listIterator(index).add(obj);
    }

    /**
     * Get the element at position index.
     * @param index Position of item to be retrieved
     * @return The item at index
     */
    @Override
    public E get(int index) {
        return listIterator(index).next();
    }

    /**
     * Return the size of the list
     * @return the size of the list
     */
    @Override
    public int size() {
        return size;
    }

    // Inner Classes
    /** 
     * A Node is the building block for a double-linked list.
     */
    private static class Node<E> {

        /** The data value. */
        private E data;
        /** The link to the next node. */
        private Node<E> next = null;
        /** The link to the previous node. */
        private Node<E> prev = null;

        /**
         * Construct a node with the given data value.
         * @param dataItem The data value
         */
        private Node(E dataItem) {
            data = dataItem;
        }
    } //end class Node

    /** Inner class to implement the ListIterator interface. */
    private class KWListIter implements ListIterator<E> {

        /** A reference to the next item. */
        private Node<E> nextItem;
        /** A reference to the last item returned. */
        private Node<E> lastItemReturned;
        /** The index of the current item. */
        private int index = 0;

        /**
         * Construct a KWListIter that will reference the ith item.
         * @param i The index of the item to be referenced
         */
        public KWListIter(int i) {
            // Validate i parameter.
            if (i < 0 || i > size) {
                throw new IndexOutOfBoundsException(
                        "Invalid index " + i);
            }
            lastItemReturned = null; // No item returned yet.
            // Special case of last item.
            if (i == size) {
                index = size;
                nextItem = null;
            } else { // Start at the beginning
                nextItem = head;
                for (index = 0; index < i; index++) {
                    nextItem = nextItem.next;
                }
            }
        }

        /**
         * Construct a KWListIter that is a copy of another KWListIter
         * @param other The other KWListIter
         */
        public KWListIter(KWListIter other) {
            KWListIter itr = new KWListIter(0);
            itr.index = other.index;
            itr.lastItemReturned = other.lastItemReturned;
            itr.nextItem = other.nextItem;
        }

        /**
         * Indicate whether movement forward is defined.
         * @return true if call to next will not throw an exception
         */
        @Override
        public boolean hasNext() {
            return nextItem != null;
        }

        /** Move the iterator forward and return the next item.
        @return The next item in the list
        @throws NoSuchElementException if there is no such object
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            index++;
            return lastItemReturned.data;
        }

        /**
         * Indicate whether movement backward is defined.
         * @return true if call to previous will not throw an exception
         */
        @Override
        public boolean hasPrevious() {
            return (nextItem == null && size != 0)
                    || nextItem.prev != null;
        }

        /**
         * Return the index of the next item to be returned by next
         * @return the index of the next item to be returned by next
         */
        @Override
        public int nextIndex() {
            return index;
        }

        /**
         * Return the index of the next item to be returned by previous
         * @return the index of the next item to be returned by previous
         */
        @Override
        public int previousIndex() {
            return index - 1;
        }

        /**
         * Move the iterator backward and return the previous item.
         * @return The previous item in the list
         * @throws NoSuchElementException if there is no such object
         */
        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (nextItem == null) { // Iterator past the last element
                nextItem = tail;
            } else {
                nextItem = nextItem.prev;
            }
            lastItemReturned = nextItem;
            index--;
            return lastItemReturned.data;
        }

        /**
         * Add a new item between the item that will be returned
         * by next and the item that will be returned by previous.
         * If previous is called after add, the element added is
         * returned.
         * @param obj The item to be inserted
         */
        @Override
        public void add(E obj) {
            if (head == null) { // Add to an empty list.
                head = new Node<E>(obj);
                tail = head;
            } else if (nextItem == head) { // Insert at head.
                // Create a new node.
                Node<E> newNode = new Node<E>(obj);
                // Link it to the nextItem.
                newNode.next = nextItem; // Step 1
                // Link nextItem to the new node.
                nextItem.prev = newNode; // Step 2
                // The new node is now the head.
                head = newNode; // Step 3
            } else if (nextItem == null) { // Insert at tail.
                // Create a new node.
                Node<E> newNode = new Node<E>(obj);
                // Link the tail to the new node.
                tail.next = newNode; // Step 1
                // Link the new node to the tail.
                newNode.prev = tail; // Step 2
                // The new node is the new tail.
                tail = newNode; // Step 3
            } else { // Insert into the middle.
                // Create a new node.
                Node<E> newNode = new Node<E>(obj);
                // Link it to nextItem.prev.
                newNode.prev = nextItem.prev; // Step 1
                nextItem.prev.next = newNode; // Step 2
                // Link it to the nextItem.
                newNode.next = nextItem; // Step 3
                nextItem.prev = newNode; // Step 4
            }
            // Increase size and index and set lastItemReturned.
            size++;
            index++;
            lastItemReturned = null;
        } // End of method add.

// Insert solution to programming exercise 1, section 8, chapter 2 here
        // Page 121
        // implement the KWListIter.remove method

        /**
         * Removes an object from the KWLinkedList based on the position of the KWListIter's index
         * @throws IllegalStateException if the lastItemReturned is null
         */
        @Override
        public void remove() throws IllegalStateException
        {
            if(lastItemReturned != null)
            {
                if(lastItemReturned.next != null)
                {
                    lastItemReturned.next.prev = lastItemReturned.prev;
                }
                else
                {
                    tail = lastItemReturned.prev;

                    if(tail == null)
                    {
                        head = null;
                    }
                    else
                    {
                        tail.next = null;
                    }
                }

                if(lastItemReturned.prev != null)
                {
                    lastItemReturned.prev.next = lastItemReturned.next;
                }
                else
                {
                    head = lastItemReturned.next;

                    if(head == null)
                    {
                        tail = null;
                    }
                    else
                    {
                        head.prev = null;
                    }
                }

                lastItemReturned = null;
                size--;
                index--;
            }
            else
            {
                throw new IllegalStateException();
            }
        }

// Insert solution to programming exercise 2, section 8, chapter 2 here
        // Page 121
        // Implement the KWListIter.set method

        /**
         *
         * @param dataItem the data which replaces the data previously stored in the lastItemReturned
         * @throws IllegalStateException if the lastItemReturned is null
         */
        public void set(E dataItem) throws IllegalStateException
        {
            if(lastItemReturned != null)
            {
                lastItemReturned.data = dataItem;
            }
            else
            {
                throw new IllegalStateException();
            }
        }

    } //end class KWListIter

// Insert solution to programming exercise 1, section 7, chapter 2 here
    // Page 112
    // Write the method indexOf as specified in the List interface by adapting the code
    // shown in Example 2.14 to return the index of the first occurrence of an object

    /**
     *
     * @param dataItem the data which will be searched for inside the KWLinkedList
     * @return int value of the position that the first occurrence of the data is found
     *          at inside the KWLinkedList, else -1
     */
    @Override
    public int indexOf(Object dataItem)
    {
        KWListIter iterator = (KWListIter) listIterator(0);

        while(iterator.hasNext())
        {
            if(dataItem.equals(iterator.next()))
            {
                return iterator.nextIndex();
            }
        }

        // if not found
        return -1;
    }

// Insert solution to programming exercise 2, section 7, chapter 2 here
    // Page 112
    // Write the method lastIndexOf specified in the List interface by adapting the code
    // shown in Example 2.14 to return the index of the last occurrence of an object

    /**
     *
     * @param dataItem the data which will be searched for inside the KWLinkedList
     * @return int value of the position that the last occurrence of the data is found
     *          at inside the KWLinkedList, else -1
     */
    @Override
    public int lastIndexOf(Object dataItem)
    {
        KWListIter iterator = (KWListIter) listIterator(size);

        while(iterator.hasPrevious())
        {
            if(dataItem.equals(iterator.previous()))
            {
                return iterator.previousIndex();
            }
        }

        // if not found
        return -1;
    }

// Insert solution to programming exercise 3, section 7, chapter 2 here
    // Page 112
    // Write a method indexOfMin that returns the index of the minimum item in a List,
    // assuming that each item in the list implements the Comparable interface

    /**
     *
     * @return int value of the position of the node that contains the minimum value
     *          based on the compareTo method, else -1
     */
    public int indexOfMin()
    {
        KWListIter iterator = (KWListIter) listIterator(0);

        Comparable<E> min = null;

        if(iterator.hasNext())
        {
            min = (Comparable<E>) iterator.next();
        }
        else
        {
            return -1;
        }

        E next = null;

        while(iterator.hasNext())
        {
            next = iterator.next();

            if(min.compareTo(next) > 0)
            {
                min = (Comparable<E>) next;
            }
        }

        return indexOf(min);
    }

// Insert solution to programming exercise 1, section 6, chapter 2 here
    // Page 104
    // For the double-linked list shown in Figure 2.20., assume head references the first
    // list node and tail references the last list node.  Write statements to do each of the
    // following.
    //   a. Insert "Bill" before "Tom"
    //   b. Insert "Sue" before "Sam"
    //   c. Remove "Bill"
    //   d. Remove "Sam"

    /**
     * Removes all elements within the LinkedList then completes all steps
     *          in exercise 1, section 6, chapter 2 in the text book
     */
    public void billy()
    {
        this.removeRange(0, size);

        // Initial Nodes
        Node<E> tom = new Node<E>((E)"Tom");
        Node<E> dick = new Node<E>((E)"Dick");
        Node<E> harry = new Node<E>((E)"Harry");
        Node<E> sam = new Node<E>((E)"Sam");

        // Extra Nodes
        Node<E> bill = new Node<E>((E)"Bill");
        Node<E> sue = new Node<E>((E)"Sue");

        // Figure 2.20 initial list
        this.addFirst((E) sam.data);
        this.addFirst((E) harry.data);
        this.addFirst((E) dick.data);
        this.addFirst((E) tom.data);

        // Insert bill before tom
        this.addFirst((E)bill.data);

        // Insert sue before sam
        sue.next = tail;
        sue.prev = tail.prev;
        tail.prev.next = sue;
        tail.prev = sue;

        // Remove bill
        this.removeFromStart();

        // Remove sam
        sue.next = sam.next;
        bill.prev = sue;
        sam = null;
    }


    /**
     *
     * @return removedData the data contained in the node
     *          removed from the start of the LinkedList
     */
    public E removeFromStart()
    {
        KWListIter iterator = new KWListIter(0);

        E removedData = null;

        if(iterator.hasNext())
        {
            removedData = iterator.next();
            iterator.remove();
        }

        return removedData;
    }

    /**
     *
     * @param dataItem the data to be searched for to be removed within the LinkedList
     * @return removedData the data contained within the removed node(s)
     */
    public E removeByName(E dataItem)
    {
        KWListIter iterator = new KWListIter(0);;

        E removedData = null;
        E currentData = null;

        while(iterator.hasNext())
        {
            currentData = iterator.next();

            if(currentData.equals(dataItem))
            {
                removedData = currentData;
                iterator.remove();
            }
        }
        return removedData;
    }

    /**
     * Displays the toString of all data elements within the LinkedList
     */
    public void printData()
    {
        KWListIter iterator = new KWListIter(0);

        while(iterator.hasNext())
        {
            System.out.println(iterator.next().toString());
        }
    }
}
/*</listing>*/
