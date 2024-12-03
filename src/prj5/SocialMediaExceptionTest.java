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
 * Tests the SocialMediaException class.
 * 
 * @author bradl
 * @version Dec 2, 2024
 */
public class SocialMediaExceptionTest
    extends TestCase
{
    // ~ Fields ................................................................
    @SuppressWarnings("unused")
    private SocialMediaException e;

    // ~ Constructors ..........................................................
    /**
     * Initializes a new SocialMediaException object.
     */
    public void setUp()
    {
        e = new SocialMediaException("test");
    }


    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * Tests the social
     * 
     * @throws SocialMediaException
     *             as a test
     */
    public void testException()
        throws SocialMediaException
    {
        Exception exception = null;
        try
        {
            throw e;
        }
        catch (SocialMediaException e1)
        {
            exception = e1;
        }
        assertNotNull(exception);
    }
}
