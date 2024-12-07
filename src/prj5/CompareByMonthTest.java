package prj5;

import student.TestCase;

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
    private CompareByMonth reach1;
    private CompareByMonth reach2;

    private InteractionData january;
    private InteractionData february;
    private InteractionData march;

    private InteractionData january2;
    private InteractionData february2;
    private InteractionData march2;

    private Influencer left;
    private Influencer right;

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    public void setUp()
    {
        trad1 = new CompareByMonth(true, 0);
        trad2 = new CompareByMonth(true, 1);

        reach1 = new CompareByMonth(false, 0);
        reach2 = new CompareByMonth(false, 1);

        left = new Influencer("s", "s", "s", "s");
        right = new Influencer("s", "s", "s", "s");

        january = new InteractionData(10, 10, 10, 10, 2, "January");
        february = new InteractionData(20, 20, 20, 20, 10, "February");
        march = new InteractionData(30, 30, 30, 30, 10, "March");

        january2 = new InteractionData(10, 10, 10, 10, 1, "January");
        february2 = new InteractionData(20, 20, 20, 20, 5, "February");
        march2 = new InteractionData(30, 30, 30, 30, 5, "March");
    }


    public void testCompare()
    {
        left.getMonthData().add(february);
        right.getMonthData().add(january);

        // for some reason it returns 200 no matter what interaction data is in
        // the first slot
        System.out.println(
            left.getMonthData().getEntry(0).getTraditionalEngagementRate());
        System.out.println(
            right.getMonthData().getEntry(0).getTraditionalEngagementRate());

        assertEquals(0, trad1.compare(left, right));
    }
}
