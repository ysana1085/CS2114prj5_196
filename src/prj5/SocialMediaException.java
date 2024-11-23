// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bradley Roos (bradleyroos@vt.edu)

package prj5;

// -------------------------------------------------------------------------
/**
 * Represents an exception thrown when the engagement rate of a social media
 * influencer can't be calculated due to incomplete data.
 * 
 * @author bradl
 * @version Nov 22, 2024
 */
public class SocialMediaException
    extends Exception
{
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * Create a new SocialMediaException object.
     * 
     * @param s
     *            provided error message
     */
    public SocialMediaException(String s)
    {
        super(s);
    }
}
