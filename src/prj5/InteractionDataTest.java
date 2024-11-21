package prj5;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * The InteractionDataTest class provides unit tests for the InteractionData
 * class, validating its methods for correctness. This includes tests for all
 * getter methods as well as calculations for traditional engagement rate and
 * engagement rate by reach. The test class uses the student.TestCase framework
 * to ensure that the InteractionData methods perform as expected under various
 * scenarios, including edge cases like zero followers or views.
 * 
 * @author Yashvasin Sana
 * @version Nov 19, 2024
 */
public class InteractionDataTest
    extends TestCase
{
    // ~ Fields ................................................................

    private InteractionData influencer;

    // ~ Constructors ..........................................................

    public void setUp()
    {
        influencer =
            new InteractionData(22876452, 333, 4650272, 518, 170095, "January");
    }
    // ~Public Methods ........................................................

    // ----------------------------------------------------------


    /**
     * Tests getLikes() method of the InteractionData class.
     */
    public void testGetLikes()
    {
        assertEquals(22876452, influencer.getLikes());
    }

    // ----------------------------------------------------------


    /**
     * Tests getLikes() method of the InteractionData class.
     */
    public void testGetPosts()
    {
        assertEquals(333, influencer.getPosts());
    }


    /**
     * Tests getFollowers() method of the InteractionData class.
     */
    public void testGetFollowers()
    {
        assertEquals(4650272, influencer.getFollowers());
    }


    /**
     * Tests getComments() method of the InteractionData class.
     */
    public void testGetComments()
    {
        assertEquals(518, influencer.getComments());
    }


    /**
     * Tests getViews() method of the InteractionData class.
     */
    public void testGetViews()
    {
        assertEquals(170095, influencer.getViews());
    }


    /**
     * Tests getMonth() method of the InteractionData class.
     */
    public void testGetMonth()
    {
        assertEquals("January", influencer.getMonth());
    }


    /**
     * Tests getTraditionalEngagementRate() method of the InteractionData class.
     */
    public void testGetTraditionalEngagementRate()
    {
        assertEquals("491.9%", influencer.getTraditionalEngagementRate());

        influencer = new InteractionData(100, 50, 0, 50, 100, "February");
        assertEquals(
            "Invalid follower count",
            influencer.getTraditionalEngagementRate());

        influencer = new InteractionData(0, 50, 1000, 0, 100, "March");
        assertEquals("0%", influencer.getTraditionalEngagementRate());
    }


    /**
     * Tests getReachEngagementRate() method of the InteractionData class.
     */
    public void testGetReachEngagementRate()
    {
        assertEquals("13449.5%", influencer.getReachEngagementRate());

        influencer = new InteractionData(100, 50, 1000, 50, 0, "February");
        assertEquals("Invalid view count", influencer.getReachEngagementRate());

        influencer = new InteractionData(0, 50, 1000, 0, 100, "March");
        assertEquals("0%", influencer.getTraditionalEngagementRate());

    }
}
