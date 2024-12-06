// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bradley Roos (bradleyroos@vt.edu)

package prj5;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Provides unit tests for the CompareByTraditional class.
 * 
 * @author bradl
 * @version Nov 20, 2024
 */
public class CompareByTraditionalTest
    extends TestCase
{
    // ~ Fields ................................................................
    private CompareByTraditional comp;
    private Influencer left;
    private Influencer right;

    // ~ Constructors ..........................................................
    /**
     * Instantiates a new CompareByTraditional object. Instantiates two new
     * Influencer objects.
     */
    public void setUp()
    {
        comp = new CompareByTraditional();
        left = new Influencer("ab", "cd", "ef", "gh");
        right = new Influencer("cd", "ef", "gh", "ij");
    }


    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * Tests compare with InteractionData lists of varying size and elements.
     */
    public void testCompare()
    {
        assertEquals(comp.compare(left, right), 0);
        assertEquals(comp.compare(right, left), 0);
        left.getMonthData().add(
            new InteractionData(
                22876452,
                333,
                4650272,
                518,
                170095,
                "January"));
        right.getMonthData().add(
            new InteractionData(
                22876452,
                333,
                4650272,
                518,
                170095,
                "January"));
        assertEquals(comp.compare(left, right), 0);
        left.getMonthData().add(
            new InteractionData(
                2000000,
                333,
                23458956,
                518,
                170095,
                "February"));
        right.getMonthData().add(
            new InteractionData(
                3000000,
                333,
                37567549,
                518,
                170095,
                "February"));
        assertEquals(comp.compare(left, right), 1);
        assertEquals(comp.compare(right, left), -1);
    }
}
