// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bradley Roos (bradleyroos@vt.edu)

package prj5;

import list.AList;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test class for Influencer.
 * 
 * @author bradl
 * @version Nov 20, 2024
 */
public class InfluencerTest
    extends TestCase
{
    // ~ Fields ................................................................
    private Influencer influencer1;
    private Influencer influencer2;
    private Influencer influencer3;
    private Influencer influencer4;
    private Influencer influencer5;
    private Influencer influencer6;
    private Object nullObj;
    private Object obj;

    // ~ Constructors ..........................................................
    /**
     * Initializes six Influencer objects. Initializes one Object object.
     */
    public void setUp()
    {
        influencer1 = new Influencer("ab", "cd", "ef", "gh");
        influencer2 = new Influencer("ab", "cd", "ef", "ij");
        influencer3 = new Influencer("ab", "cd", "ij", "gh");
        influencer4 = new Influencer("ab", "ij", "ef", "gh");
        influencer5 = new Influencer("ij", "cd", "ef", "gh");
        influencer6 = new Influencer("ab", "cd", "ef", "gh");
        obj = new Object();
    }


    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * Tests getUsername, getChannelName, getCountry, and getMainTopic by
     * comparing the return value with the expected value. Tests getMonthData
     * with an empty list and with an element added by comparing the return
     * value with the expected value.
     */
    public void testGetters()
    {
        assertEquals(influencer1.getUsername(), "ab");
        assertEquals(influencer1.getChannelName(), "cd");
        assertEquals(influencer1.getCountry(), "ef");
        assertEquals(influencer1.getMainTopic(), "gh");
        AList<InteractionData> list = new AList<InteractionData>();
        assertTrue(influencer1.getMonthData().equals(list));
        list.add(
            new InteractionData(
                22876452,
                333,
                4650272,
                518,
                170095,
                "January"));
        influencer1.getMonthData().add(
            new InteractionData(
                22876452,
                333,
                4650272,
                518,
                170095,
                "January"));
        assertEquals(influencer1.getMonthData().getLength(), 1);
        assertTrue(influencer1.getMonthData().equals(list));
    }


    // ----------------------------------------------------------
    /**
     * tests firstQuarterTraditionalEngagementRate
     */
    public void testFirstQuarterTraditionalEngagementRate()
    {
        AList<InteractionData> list1 = influencer1.getMonthData();
        list1.add(new InteractionData(1500, 0, 0, 100, 30, "January"));
        list1.add(new InteractionData(1500, 0, 0, 100, 30, "February"));
        list1.add(new InteractionData(1500, 0, 0, 100, 30, "March"));
        assertEquals("0", influencer1.firstQuarterTraditionalEngagementRate());
        AList<InteractionData> list2 = influencer1.getMonthData();
        list2.add(
            new InteractionData(
                22876452,
                333,
                4650272,
                518,
                170095,
                "January"));
        list2.add(
            new InteractionData(
                20000000,
                333,
                4650272,
                518,
                170095,
                "February"));
        list2.add(
            new InteractionData(10000000, 333, 4650272, 518, 170095, "March"));
        assertEquals(
            "1137.1",
            influencer1.firstQuarterTraditionalEngagementRate());
    }


    /**
     * tests firstQuarterReachEngagementRate
     */
    public void testFirstQuarterReachEngagementRate()
    {
        AList<InteractionData> list1 = influencer1.getMonthData();
        list1.add(new InteractionData(1500, 100, 0, 0, 0, "January"));
        list1.add(new InteractionData(1500, 100, 0, 0, 0, "February"));
        list1.add(new InteractionData(1500, 100, 0, 0, 0, "March"));
        assertEquals("0", influencer1.firstQuarterReachEngagementRate());
        AList<InteractionData> list2 = influencer1.getMonthData();
        list2.add(
            new InteractionData(
                22876452,
                333,
                4650272,
                518,
                170095,
                "January"));
        list2.add(
            new InteractionData(
                20000000,
                333,
                4650272,
                518,
                170095,
                "February"));
        list2.add(
            new InteractionData(10000000, 333, 4650272, 518, 170095, "March"));
        assertEquals("10362.4", influencer1.firstQuarterReachEngagementRate());

    }


    /**
     * tests equals
     */
    public void testEquals()
    {
        // todo create test class
        assertTrue(influencer1.equals(influencer1));
        assertFalse(influencer1.equals(nullObj));
        assertFalse(influencer1.equals(obj));
        assertFalse(influencer1.equals(influencer2));
        assertFalse(influencer1.equals(influencer3));
        assertFalse(influencer1.equals(influencer4));
        assertFalse(influencer1.equals(influencer5));
        assertTrue(influencer1.equals(influencer6));

    }


    /**
     * Test method for setChannelName
     */
    public void testSetChannelName()
    {
        assertEquals("cd", influencer1.getChannelName());
        influencer1.setChannelName("not cd");
        assertEquals("not cd", influencer1.getChannelName());
    }
}
