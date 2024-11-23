// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Lakshith Baskar Rao (9066-93142)

// -------------------------------------------------------------------------
package prj5;

import java.util.Comparator;

/**
 * The DLinkedList class represents a doubly linked list which contains sentinal
 * nodes. It implements the List Interface and contains all methods to cover the
 * functionality for a doubly linked list.
 *
 * @author Lakshith
 * @version Nov 19, 2024
 * @param <T>
 */
public class DLinkedList<T>
    implements ListInterface<T>
{
    // ~ Fields ................................................................
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // ~ Constructors ..........................................................
    /**
     * Creates and initializes a doubly linked list by calling the init method
     * (from week 10 lab).
     */
    public DLinkedList()
    {
        head = new DLinkedList.Node<T>(null);
        tail = new DLinkedList.Node<T>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }


    // ~Public Methods ........................................................
    // ----Note: A majority of the methods implemented in this class followed
    // the lab in week 10 as an example and was readapted to meet our project's
    // requirments
    /**
     * Adds the object to the end of the list.
     *
     * @param anEntry
     *            the object to add
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(T anEntry)
    {
        add(getLength(), anEntry);
    }


    /**
     * Adds the object to the position in the list
     *
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(int index, T obj)
    {
        if (index < 0 || size < index)
        {
            throw new IndexOutOfBoundsException();
        }
        if (obj == null)
        {
            throw new IllegalArgumentException(
                "Cannot add null " + "objects to a list");
        }
        Node<T> nodeAfter;
        if (index == size)
        {
            nodeAfter = tail;
        }
        else
        {
            nodeAfter = getNodeAtIndex(index);
        }
        Node<T> addition = new Node<T>(obj);
        addition.setPrevious(nodeAfter.previous());
        addition.setNext(nodeAfter);
        nodeAfter.previous().setNext(addition);
        nodeAfter.setPrevious(addition);
        size++;
    }


    /**
     * Helper method gets the node at that index Taken from week 10 lab.
     *
     * @param index
     * @return node at index
     */
    private Node<T> getNodeAtIndex(int index)
    {
        if (index < 0 || getLength() <= index)
        {
            throw new IndexOutOfBoundsException(
                "No element exists at " + index);
        }
        Node<T> current = head.next(); // as we have a sentinel node
        for (int i = 0; i < index; i++)
        {
            current = current.next();
        }
        return current;
    }


    /**
     * Removes an instance of an object at a specific position from the list and
     * returns it
     *
     * @param givenPosition
     *            the position of the object to be removed
     * @return T The object that was removed
     */
    public T removePosition(int givenPosition)
    {
        Node<T> nodeToBeRemoved = getNodeAtIndex(givenPosition);
        nodeToBeRemoved.previous().setNext(nodeToBeRemoved.next());
        nodeToBeRemoved.next().setPrevious(nodeToBeRemoved.previous());
        size--;
        return nodeToBeRemoved.getData();
    }


    /**
     * Removes all of the elements from the list
     *
     * @postcondition size = 0 and all of the nodes are removed
     */
    public void clear()
    {
        head = new DLinkedList.Node<T>(null);
        tail = new DLinkedList.Node<T>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }


    /**
     * Replaces the current entry in a list with a new entry at a specific
     * position
     *
     * @param givenPosition
     *            The position at which the current entry is being replaced
     * @param newEntry
     *            The newEntry which is replacing the current entry at given
     *            position
     * @return The replaced element
     */
    public T replace(int givenPosition, T newEntry)
    {
        Node<T> replaceNode = getNodeAtIndex(givenPosition);
        T data = replaceNode.getData();
        replaceNode.setData(newEntry);
        return data;
    }


    /**
     * Gets the entry at the given position
     *
     * @param givenPosition
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if there is not a node at the given index
     */
    public T getEntry(int givenPosition)
    {
        return getNodeAtIndex(givenPosition).getData();
    }


    /**
     * Returns an array representation of the list If a list contains A, B, and
     * C, the following should be returned [A, B, C]
     *
     * @return an array representing the list
     */
    @SuppressWarnings("unchecked")
    public T[] toArray()
    {
        T[] arr = (T[]) new Object[size];
        Node<T> curr = head.next();
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = curr.getData();
            curr = curr.next();
        }
        return arr;
    }


    /**
     * Checks if the list contains the given entry
     *
     * @param anEntry
     *            the object to check for
     * @return true if it contains the object
     * @throws IndexOutOfBoundsException
     *             if an element does not exist at the given index
     */
    public boolean contains(T anEntry)
    {
        return lastIndexOf(anEntry) != -1; // taken from week 10 lab
    }


    /**
     * Gets the last time the given object is in the list Taken from week 10 lab
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    public int lastIndexOf(T obj)
    {
        Node<T> current = tail.previous();
        for (int i = getLength() - 1; i >= 0; i--)
        {
            if (current.getData().equals(obj))
            {
                return i;
            }
            current = current.previous();
        }
        return -1;
    }


    /**
     * Gets the length of the doubly linked list
     *
     * @return the length of the current list
     */
    public int getLength()
    {
        return size;
    }


    /**
     * Checks if the array is empty
     *
     * @return if the array is empty
     */
    public boolean isEmpty()
    {
        return size == 0;
    }


    /**
     * The sort method uses an insertion sort to sort an array of months based
     * on order. Taken from course notes on Comparing and Sorting
     *
     * @param array
     *            The array being sorted using insertion sort
     * @param first
     *            The first element in the array
     * @param last
     *            The last element in the array
     */
    public void sort(T[] array, int first, int last, Comparator<T> comp)
    {
        for (int i = first + 1; i <= last; i++)
        {
            insertInOrder(array[i], array, first, i - 1, comp);
        }
    }


    /**
     * Helper method to help sort the elements using a comparator. Taken from
     * course notes on Comparing and Sorting
     *
     * @param anEntry
     *            The entry being sorted in the array
     * @param a
     *            The array of elements to be sorted.
     * @param begin
     *            The start of the array where the insertion sort beings.
     * @param end
     *            The end of the array
     */
    private void insertInOrder(T anEntry, T[] a, int begin, int end, Comparator<T> comp)
    {
        int index = end;
        while ((index >= begin) && comp.compare(anEntry, a[index]) < 0)
        {
            a[index + 1] = a[index];
            index--;
        }
        a[index + 1] = anEntry;
    }

    /**
     * This represents a node in a doubly linked list. This node stores data, a
     * pointer to the node before it in the list, and a pointer to the node
     * after it in the list This was taken from week 10 lab - doubly linked list
     * debugging.
     *
     * @param <E>
     *            This is the type of object that this class will store
     * @author Mark Wiggans (mmw125)
     * @version 4/14/2015
     */
    private static class Node<E>
    {
        private Node<E> next;
        private Node<E> previous;
        private E data;

        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(E d)
        {
            data = d;
        }


        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<E> n)
        {
            next = n;
        }


        /**
         * Sets the node before this one
         *
         * @param n
         *            the node before this one
         */
        public void setPrevious(Node<E> n)
        {
            previous = n;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<E> next()
        {
            return next;
        }


        /**
         * Gets the node before this one
         *
         * @return the node before this one
         */
        public Node<E> previous()
        {
            return previous;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public E getData()
        {
            return data;
        }


        /**
         * Sets the data in the node
         *
         * @param data
         *            The new data being set to
         */
        public void setData(E data)
        {
            this.data = data;
        }
    }
}
