// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Lakshith Baskar Rao (9066-93142)
package prj5;

/**
 * This provides definitions for all of the methods necessary for a list
 * implementation. This code was taken from Week 9 Lab
 * LinkedListEnhancedNewSkeleton and adapted to match our specifications for a
 * linked list interface.
 *
 * @author Mark Wiggans, maellis1, jamal93 The class that you want it to store
 * @version 4/14/2015, 10/21/2015, 10/15/2016
 * @param <T>
 *            The generic object type, T.
 */
public interface ListInterface<T> {
    /**
     * Adds the object to the end of the list.
     *
     * @param obj
     *            the object to add
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public abstract void add(T obj);


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
    public abstract void add(int index, T obj);


    /**
     * Removes an instance of an object at a specific position from the list and
     * returns it
     *
     * @param givenPosition
     *            the position of the object to be removed
     * @return T The object that was removed
     */
    public abstract T removePosition(int givenPosition);


    /**
     * Removes all of the elements from the list
     *
     * @postcondition size = 0 and all of the nodes are removed
     */
    public abstract void clear();


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
    public abstract T replace(int givenPosition, T newEntry);


    /**
     * Gets the entry at the given position
     *
     * @param givenPosition
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if there is not a node at the given index
     */
    public abstract T getEntry(int givenPosition);


    /**
     * Returns an array representation of the list If a list contains A, B, and
     * C, the following should be returned [A, B, C]
     *
     * @return an array representing the list
     */
    public abstract Object[] toArray();


    /**
     * Checks if the list contains the given entry
     *
     * @param anEntry
     *            the object to check for
     * @return true if it contains the object
     * @throws IndexOutOfBoundsException
     *             if an element does not exist at the given index
     */
    public abstract boolean contains(T anEntry);


    /**
     * Gets the length of the doubly linked list
     *
     * @return the length of the current list
     */
    public abstract int getLength();


    /**
     * Checks if the array is empty
     *
     * @return if the array is empty
     */
    public abstract boolean isEmpty();


    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    public abstract String toString();
}
