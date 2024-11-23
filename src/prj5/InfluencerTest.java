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
public class InfluencerTest extends TestCase {
    // ~ Fields ................................................................
    private Influencer influencer;

    // ~ Constructors ..........................................................
    public void setUp() {
        influencer = new Influencer("ab", "cd", "ef", "gh");
    }


    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * Tests getUsername, getChannelName, getCountry, and getMainTopic by
     * comparing the return value with the expected value. Tests getMonthData
     * with an empty list and with an element added by comparing the return
     * value with the expected value.
     */
    public void testGetters() {
        assertEquals(influencer.getUsername(), "ab");
        assertEquals(influencer.getChannelName(), "cd");
        assertEquals(influencer.getCountry(), "ef");
        assertEquals(influencer.getMainTopic(), "gh");
        AList<InteractionData> list = new AList<InteractionData>();
        assertTrue(influencer.getMonthData().equals(list));
        list.add(new InteractionData(22876452, 333, 4650272, 518, 170095,
            "January"));
        influencer.getMonthData().add(new InteractionData(22876452, 333,
            4650272, 518, 170095, "January"));
        assertTrue(influencer.getMonthData().equals(list));
        assertEquals(influencer.getMonthData().getLength(), 1);

    }


    public void testCompareToTraditional() {
        Influencer inflencer2 = new Influencer("ab", "cd", "ef", "gz");
        influencer.setIsTraditional(true);
        inflencer2.setIsTraditional(true);
        assertTrue(influencer.compareTo(inflencer2) != 0);
    }


    public void testCompareToReach() {
        Influencer influencer2 = new Influencer("ab", "bc", "ef", "gz");
        influencer.setIsTraditional(false);
        influencer2.setIsTraditional(false);
        assertTrue(influencer.compareTo(influencer2) != 0);

    }

    public void testfirstQuarterTraditionalEngagementRate() {
        
    }
    
    public void firstQuarterReachEngagementRate() {
        
    }
    
    public void testEquals() {
        
    }
}
