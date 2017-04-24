/*<listing chapter="7" number="8">*/
package edu.miracosta.cs113.hw10.project1;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Hash table implementation using chaining.
 *  @author Koffman and Wolfgang
 **/
public class HashtableChain<K, V> implements Map<K, V> {

    /** The table */
    private LinkedList<Entry<K, V>>[] table;
    /** The number of keys */
    private int numKeys;
    /** The capacity */
    private static final int CAPACITY = 101;
    /** The maximum load factor */
    private static final double LOAD_THRESHOLD = 3.0;

    /** Contains key-value pairs for a hash table. */
    private static class Entry<K, V> implements Map.Entry<K, V> {

        /** The key */
        private K key;
        /** The value */
        private V value;

        /**
         * Creates a new key-value pair.
         * @param key The key
         * @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Retrieves the key.
         * @return The key
         */
        @Override
        public K getKey() {
            return key;
        }

        /**
         * Retrieves the value.
         * @return The value
         */
        @Override
        public V getValue() {
            return value;
        }

        /**
         * Sets the value.
         * @param val The new value
         * @return The old value
         */
        @Override
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }
// Insert solution to programming exercise 3, section 4, chapter 7 here
    }

    // Constructor
    public HashtableChain() {
        table = new LinkedList[CAPACITY];
    }

    /*<listing chapter="7" number="9">*/
    /**
     * Method get for class HashtableChain.
     * @param key The key being sought
     * @return The value associated with this key if found;
     *         otherwise, null
     */
    @Override
    public V get(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            return null; // key is not in the table.
        }
        // Search the list at table[index] to find the key.
        for (Entry<K, V> nextItem : table[index]) {
            if (nextItem.key.equals(key)) {
                return nextItem.value;
            }
        }

        // assert: key is not in the table.
        return null;
    }
    /*</listing>*/

    /*<listing chapter="7" number="10">*/
    /**
     * Method put for class HashtableChain.
     * @post This key-value pair is inserted in the
     *       table and numKeys is incremented. If the key is already
     *       in the table, its value is changed to the argument
     *       value and numKeys is not changed.
     * @param key The key of item being inserted
     * @param value The value for this key
     * @return The old value associated with this key if
     *         found; otherwise, null
     */
    @Override
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            // Create a new linked list at table[index].
            table[index] = new LinkedList<Entry<K, V>>();
        }

        // Search the list at table[index] to find the key.
        for (Entry<K, V> nextItem : table[index]) {
            // If the search is successful, replace the old value.
            if (nextItem.key.equals(key)) {
                // Replace value for this key.
                V oldVal = nextItem.value;
                nextItem.setValue(value);
                return oldVal;
            }
        }

        // assert: key is not in the table, add new item.
        table[index].addFirst(new Entry<K, V>(key, value));
        numKeys++;
        if (numKeys > (LOAD_THRESHOLD * table.length)) {
            rehash();
        }
        return null;
    }

    /**
     *
     * @param key object that is removed from table
     * @return the value of the object removed from table or null if not removed
     */
    @Override
    public V remove(Object key)
    {
        int position = key.hashCode() % table.length;

        V removed = null;

        if(position < 0)
        {
            position += table.length;
        }

        if(table[position] != null)
        {
            for(Entry<K, V> currentEntry : table[position])
            {
                if(currentEntry.getKey().equals(key))
                {
                    removed = currentEntry.getValue();

                    table[position].remove(currentEntry);

                    numKeys--;

                    if(table[position].isEmpty() == true)
                    {
                        table[position] = null;
                    }

                    return removed;
                }
            }
        }

        return removed;
    }

    /**
     *
     * @param m Map that is iterated over and has its entries added into table
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> m)
    {
        if(m != null)
        {
            for(Map.Entry<? extends K, ? extends V> currentEntry : m.entrySet())
            {
                if(currentEntry != null)
                {
                    put(currentEntry.getKey(), currentEntry.getValue());
                }
            }
        }
    }

    /**
     * Iterates over LinkedList array table and sets all LinkedList to null
     */
    @Override
    public void clear() {

        for(LinkedList<Entry<K, V>> currentLinkedList : table)
        {
            currentLinkedList = null;
        }
    }

    /**
     *
     * @return set a Set of keys contained within table
     */
    @Override
    public Set<K> keySet()
    {
        Set<K> set = new HashSet<K>(numKeys);

        for(LinkedList<Entry<K, V>> currentLinkedList : table)
        {
            if(currentLinkedList != null)
            {
                for(Entry<K, V> currentEntry : currentLinkedList)
                {
                    if(currentEntry != null)
                    {
                        set.add(currentEntry.getKey());
                    }
                }
            }
        }

        return set;
    }

    /**
     *
     * @return collection a Collection of values contained within table
     */
    @Override
    public Collection<V> values()
    {
        Collection<V> collection = new HashSet<V>(numKeys);

        for(LinkedList<Entry<K, V>> currentLinkedList : table)
        {
            if(currentLinkedList != null)
            {
                for(Entry<K, V> currentEntry : currentLinkedList)
                {
                    if(currentEntry != null)
                    {
                        collection.add(currentEntry.getValue());
                    }
                }
            }
        }

        return collection;
    }

    /**
     *
     * @return new EntrySet object
     */
    @Override
    public Set<Map.Entry<K, V>> entrySet()
    {
        return new EntrySet();
    }
    /*</listing>*/

// Insert solution to programming exercise 4, section 4, chapter 7 here

// Insert solution to programming exercise 5, section 4, chapter 7 here

    /**
     *
     * @return numKeys number of elements
     */
    @Override
    public int size()
    {
        return numKeys;
    }

    /** Returns true if empty */
    public boolean isEmpty() {
        return numKeys == 0;
    }

    /**
     *
     * @param key object that is searched for
     * @return true if key is found, else false
     */
    @Override
    public boolean containsKey(Object key)
    {
        int position = key.hashCode() % table.length;

        if(position < 0)
        {
            position += table.length;
        }

        if(table[position] != null)
        {
            for(Entry<K, V> currentEntry : table[position])
            {
                if(currentEntry.getKey().equals(key))
                {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     *
     * @param value object that is searched for
     * @return true if value is found, else false
     */
    @Override
    public boolean containsValue(Object value)
    {
        for(LinkedList<Entry<K, V>> currentLinkedList : table)
        {
            if(currentLinkedList != null)
            {
                for(Entry<K, V> currentEntry : currentLinkedList)
                {
                    if(currentEntry.getValue().equals(value))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Resizes LinkedList array instance variable table
     */
    private void rehash()
    {
        LinkedList<Entry<K,V>>[] previous = table;

        table = new LinkedList[(previous.length * 2) + 1];

        for(LinkedList<Entry<K , V>> currentLinkedList : previous)
        {
            if(currentLinkedList != null)
            {
                for(Entry<K, V> currentEntry : currentLinkedList)
                {
                    put(currentEntry.getKey(), currentEntry.getValue());
                }
            }
        }
    }

// Insert solution to programming exercise 2, section 4, chapter 7 here


// Insert solution to programming project 7, chapter -1 here

    /**
     * EntrySet class from project 6, page 417
     */
    private class EntrySet extends AbstractSet<Map.Entry<K, V>>
    {
        /**
         *
         * @return new SetIterator object
         */
        @Override
        public Iterator<Map.Entry<K, V>> iterator()
        {
            return new SetIterator();
        }

        /**
         *
         * @return numKeys int as size
         */
        @Override
        public int size()
        {
            return numKeys;
        }
    }

    /**
     * SetIterator class from project 6, page 417
     */
    private class SetIterator implements Iterator<Map.Entry<K, V>>
    {
        private int position;

        private Entry<K, V> lastItemReturned;

        private Iterator<Entry<K, V>> iterator;

        public SetIterator()
        {
            position = 0;
            lastItemReturned = null;
            iterator = null;
        }

        /**
         *
         * @return true if iterator has next is true, else false
         */
        @Override
        public boolean hasNext()
        {
            if(iterator != null && iterator.hasNext() == true)
            {
                return true;
            }
            else
            {
                do
                {
                    position++;

                    if(position >= table.length)
                    {
                        return false;
                    }

                }while(table[position] == null);

                iterator = table[position].iterator();

                return iterator.hasNext();
            }
        }

        /**
         *
         * @return lastItemReturned if iterator has next item is true
         * otherwise throws NoSuchElementException
         */
        @Override
        public Map.Entry<K, V> next()
        {
            if(iterator.hasNext())
            {
                lastItemReturned = iterator.next();

                return lastItemReturned;
            }
            else
            {
                throw new NoSuchElementException();
            }
        }

        /**
         * Removes last item that was iterated over
         * @throws IllegalStateException thrown if iterator hasn't moved since last removal
         */
        @Override
        public void remove() throws IllegalStateException
        {
            if(lastItemReturned != null)
            {
                iterator.remove();
                lastItemReturned = null;
            }
            else
            {
                throw new IllegalStateException();
            }
        }
    }
}
/*</listing>*/
