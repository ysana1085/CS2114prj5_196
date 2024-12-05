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

    /**
     * Setup method for test class
     */
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
        assertEquals("491.9", influencer.getTraditionalEngagementRate());

        influencer = new InteractionData(100, 50, 0, 50, 100, "February");
        assertEquals("N/A", influencer.getTraditionalEngagementRate());

        influencer = new InteractionData(0, 50, 1000, 0, 100, "March");
        assertEquals("0", influencer.getTraditionalEngagementRate());
    }


    /**
     * Tests getReachEngagementRate() method of the InteractionData class.
     */
    public void testGetReachEngagementRate()
    {
        assertEquals("13449.5", influencer.getReachEngagementRate());

        influencer = new InteractionData(100, 50, 1000, 50, 0, "February");
        assertEquals("N/A", influencer.getReachEngagementRate());

        influencer = new InteractionData(0, 50, 1000, 0, 100, "March");
        assertEquals("0", influencer.getTraditionalEngagementRate());

    }


    /**
     * tests equals() method of the InteractionData class
     */
    public void testEquals()
    {
        // primary obj
        InteractionData influencer2 =
            new InteractionData(10, 2, 5, 3, 20, "January");

        // duplicate obj of influener 2
        InteractionData influencer3 =
            new InteractionData(10, 2, 5, 3, 20, "January");

        // different likes
        InteractionData influencer4 =
            new InteractionData(9, 2, 5, 3, 20, "January");

        // different posts
        InteractionData influencer5 =
            new InteractionData(10, 1, 5, 3, 20, "January");

        // diferent followers
        InteractionData influencer6 =
            new InteractionData(10, 2, 4, 3, 20, "January");

        // different comments
        InteractionData influencer7 =
            new InteractionData(10, 2, 5, 2, 20, "January");

        // different views
        InteractionData influencer8 =
            new InteractionData(10, 2, 5, 3, 19, "January");

        // different month
        InteractionData influencer9 =
            new InteractionData(10, 2, 5, 3, 20, "February");

        // null Object
        Object nullObj = null;

        // different type of Object
        Object obj = new Object();

        // todo create test class
        assertTrue(influencer2.equals(influencer2));
        assertFalse(influencer2.equals(nullObj));
        assertFalse(influencer2.equals(nullObj));
        assertFalse(influencer2.equals(obj));
        assertTrue(influencer2.equals(influencer3));
        assertFalse(influencer2.equals(influencer4));
        assertFalse(influencer2.equals(influencer5));
        assertFalse(influencer2.equals(influencer6));
        assertFalse(influencer2.equals(influencer7));
        assertFalse(influencer2.equals(influencer8));
        assertFalse(influencer2.equals(influencer9));

    }
}
