// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Lakshith Baskar Rao (9066-93142)
package prj5;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * The DLinkedListTest class tests all the methods in the DLinkedList class to
 * ensure the doubly linked list with sentinel nodes is correctly functioning.
 * This includes test cases for the sort methods as well.
 *
 * @author Lakshith
 * @version Nov 20, 2024
 */
public class DLinkedListTest
    extends TestCase
{
    // ~ Fields ................................................................
    private DLinkedList<String> list;

    // ~ Constructors ..........................................................
    /**
     * Sets up and initializes a doubly linked list of strings for testing.
     */
    public void setUp()
    {
        list = new DLinkedList<>();
    }


    // ~Public Methods ........................................................
    /**
     * Tests the add method to ensure an entry is added to the end of the list
     * and at a specific index depending on which method is called
     */
    public void testAdd()
    {
        assertEquals(0, list.getLength());
        list.add("january");
        assertEquals(1, list.getLength());
        list.add("february");
        list.add("march");
        assertEquals(3, list.getLength());
        list.add(0, "april");
        assertEquals("april", list.getEntry(0));
        list.add(2, "december");
        assertEquals("december", list.getEntry(2));
        // invalid index (too large - out of bounds)
        Exception e = null;
        try
        {
            list.add(10, "march");
        }
        catch (Exception exception)
        {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        // invalid - index less than zero
        try
        {
            list.add(-1, "june");
        }
        catch (Exception exception)
        {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        // null add
        try
        {
            list.add(null);
        }
        catch (Exception exception)
        {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * Tester method for removePosition to ensure the entry at given position is
     * removed from list.
     */
    public void testRemovePosition()
    {
        list.add("january");
        list.add("february");
        list.add("march");
        list.add("april");
        assertEquals(4, list.getLength());
        String str = list.removePosition(0);
        assertEquals("january", str);
        assertEquals(3, list.getLength());
        str = list.removePosition(0);
        assertEquals("february", str);
        assertEquals(2, list.getLength());
    }


    /**
     * Tester method for clear to ensure list is being cleared when called.
     */
    public void testClear()
    {
        assertEquals(0, list.getLength());
        list.add("january");
        list.add("february");
        list.add("march");
        list.add("april");
        assertEquals(4, list.getLength());
        list.clear();
        assertEquals(0, list.getLength());
    }


    /**
     * Tests the replace method to ensure an entry is replaced and the old
     * element is returned
     */
    public void testReplace()
    {
        list.add("december");
        list.add("february");
        list.add("march");
        list.add("april");
        String str = list.replace(0, "january");
        assertEquals("december", str);
        assertEquals("january", list.getEntry(0));
        str = list.replace(3, "june");
        assertEquals("april", str);
        assertEquals("june", list.getEntry(3));
    }


    /**
     * Tests the getEntry method to ensure the right entry at given position is
     * returned.
     */
    public void testGetEntry()
    {
        list.add("january");
        list.add("february");
        list.add("march");
        list.add("april");
        assertEquals("january", list.getEntry(0));
        assertEquals("february", list.getEntry(1));
        assertEquals("march", list.getEntry(2));
        assertEquals("april", list.getEntry(3));
        list.replace(0, "test");
        assertEquals("test", list.getEntry(0));
    }


    /**
     * Tests the toArray method to ensure the array representation of list is
     * returned.
     */
    public void testToArray()
    {
        DLinkedList<Influencer> temp = new DLinkedList<Influencer>();
        temp.add(new Influencer("ab", "cd", "ef", "gh"));
        temp.add(new Influencer("ab", "ef", "ef", "gh"));
        temp.add(new Influencer("ab", "gh", "ef", "gh"));
        Influencer[] result = { new Influencer("ab", "cd", "ef", "gh"),
            new Influencer("ab", "ef", "ef", "gh"),
            new Influencer("ab", "gh", "ef", "gh") };
        Influencer[] arr = temp.toArray();
        for (int i = 0; i < result.length; i++)
        {
            assertEquals(result[i], arr[i]);
        }
    }


    /**
     * Tests the contains method to check if a list contains an entry.
     */
    public void testContains()
    {
        list.add("january");
        list.add("february");
        list.add("march");
        assertTrue(list.contains("january"));
        assertTrue(list.contains("february"));
        assertTrue(list.contains("march"));
        assertFalse(list.contains("june"));
        list.add("june");
        assertTrue(list.contains("june"));
        Exception exception = null;
        try
        {
            list.removePosition(5);
        }
        catch (IndexOutOfBoundsException e)
        {
            exception = e;
        }
        assertNotNull(exception);
    }


    /**
     * Tests the get length method to ensure proper length of list is returned.
     */
    public void testGetLength()
    {
        assertEquals(0, list.getLength());
        list.add("january");
        assertEquals(1, list.getLength());
        list.add("february");
        list.add("march");
        assertEquals(3, list.getLength());
        list.clear();
        assertEquals(0, list.getLength());
    }


    /**
     * Tests the isEmpty method to ensure it returns true when list is empty.
     */
    public void testIsEmpty()
    {
        assertTrue(list.isEmpty());
        list.add("january");
        list.add("february");
        list.add("march");
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }


    /**
     * Tests the getLastIndexOf to ensure last index of an element is returned.
     */
    public void testLastIndexOf()
    {
        list.add("january");
        list.add("february");
        list.add("march");
        assertEquals(2, list.lastIndexOf("march"));
        list.add("march");
        assertEquals(3, list.lastIndexOf("march"));
        assertEquals(-1, list.lastIndexOf("june"));
    }


    /**
     * Tests the sort method to ensure the correct logic of insertion sort is
     * used.
     */
    public void testSort()
    {
        DLinkedList<Influencer> temp = new DLinkedList<>();
        temp.add(new Influencer("ab", "cd", "ef", "gh"));
        temp.add(new Influencer("ab", "gh", "ef", "gh"));
        temp.add(new Influencer("ab", "ef", "ef", "gh"));
        Influencer[] arr = temp.toArray();
        Influencer[] result = { new Influencer("ab", "cd", "ef", "gh"),
            new Influencer("ab", "ef", "ef", "gh"),
            new Influencer("ab", "gh", "ef", "gh") };
        temp.insertionSort(new CompareByName());
        // ensure months are sorted alphabetically
        for (int i = 0; i < arr.length; i++)
        {
            assertTrue(arr[i].equals(result[i]));
        }
    }

}
