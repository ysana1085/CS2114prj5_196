package prj5;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests CompareByName class.
 * 
 * @author bradl
 * @version Dec 2, 2024
 */
public class CompareByNameTest
    extends TestCase
{
    // ~ Fields ................................................................
    private CompareByName comp;
    private Influencer left;
    private Influencer right;
    private Influencer leftUpper;
    private Influencer rightUpper;

    // ~ Constructors ..........................................................
    /**
     * Instantiates a CompareByName object and four Influencer objects.
     */
    public void setUp()
    {
        comp = new CompareByName();
        left = new Influencer("ab", "cd", "ef", "gh");
        right = new Influencer("cd", "ef", "gh", "ij");
        leftUpper = new Influencer("ab", "cd", "ef", "gh");
        rightUpper = new Influencer("cd", "ef", "gh", "ij");
    }


    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * Tests compare()
     */
    public void testCompare()
    {
        assertEquals(comp.compare(left, right), 2);
        assertEquals(comp.compare(left, left), 0);
        assertEquals(comp.compare(right, left), -2);
        assertEquals(comp.compare(leftUpper, rightUpper), 2);
        assertEquals(comp.compare(rightUpper, leftUpper), -2);
    }
}
