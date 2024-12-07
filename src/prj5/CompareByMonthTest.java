
package prj5;

import student.TestCase;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Yashvasin Sana (ysana1085)

// -------------------------------------------------------------------------
/**
 * Test class of CompareByMonth
 * 
 * @author Yashvasin Sana
 * @version Dec 6, 2024
 */
public class CompareByMonthTest
    extends TestCase
{
    // ~ Fields ................................................................
    private CompareByMonth trad1;
    private CompareByMonth trad2;
    private CompareByMonth trad3;

    private CompareByMonth reach1;
    private CompareByMonth reach2;

    private InteractionData january;
    private InteractionData february;

    private InteractionData january2;
    private InteractionData february2;

    private InteractionData zeroViews;
    private InteractionData zeroFollowers;

    private Influencer left;
    private Influencer right;

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

    /**
     * Set up for the test methods
     */
    public void setUp()
    {
        trad1 = new CompareByMonth(true, 0);
        trad2 = new CompareByMonth(true, 1);
        trad3 = new CompareByMonth(true, 2); // out of bounds for null

        reach1 = new CompareByMonth(false, 0);
        reach2 = new CompareByMonth(false, 1);

        left = new Influencer("s", "s", "s", "s");
        right = new Influencer("s", "s", "s", "s");

        january = new InteractionData(10, 10, 2, 10, 2, "January");
        february = new InteractionData(20, 20, 2, 20, 2, "February");

        january2 = new InteractionData(10, 10, 1, 10, 1, "January");
        february2 = new InteractionData(20, 20, 1, 20, 1, "February");

        zeroFollowers = new InteractionData(20, 20, 0, 0, 0, "January");
        zeroViews = new InteractionData(30, 30, 0, 0, 0, "January");
    }


    // ----------------------------------------------------------
    /**
     * tests compare method
     */
    public void testCompare()
    {
        // different engagement rates
        left.getMonthData().add(january);
        right.getMonthData().add(january2);

        System.out.println(
            left.getMonthData().getEntry(0).getTraditionalEngagementRate());
        System.out.println(
            right.getMonthData().getEntry(0).getTraditionalEngagementRate());

        assertEquals(1, trad1.compare(left, right));
        assertEquals(1, reach1.compare(left, right));

        left.getMonthData().add(february);
        right.getMonthData().add(february2);

        assertEquals(1, trad2.compare(left, right));
        assertEquals(1, reach2.compare(left, right));

        Exception exception = null;
        try
        {
            trad3.compare(left, right);
        }
        catch (IndexOutOfBoundsException e)
        {
            exception = e;
        }
        assertNotNull(exception);

    }


    // ----------------------------------------------------------
    /**
     * Tests compare with the same objects
     */
    public void testCompareSameObject()
    {
        left.getMonthData().add(january);
        right.getMonthData().add(january);
        assertEquals(0, trad1.compare(left, right));

        left.getMonthData().clear();
        right.getMonthData().clear();
        left.getMonthData().add(zeroFollowers);
        right.getMonthData().add(zeroViews);
        assertEquals(0, trad1.compare(left, right));

        left.getMonthData().clear();
        right.getMonthData().clear();
        left.getMonthData().add(zeroFollowers);
        right.getMonthData().add(zeroViews);
        assertEquals(0, reach1.compare(left, right));
    }
}
