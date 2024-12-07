package prj5;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  Test class of CompareByMonth
 * 
 *  @author Yashvasin Sana
 *  @version Dec 6, 2024
 */
public class CompareByMonthTest
    extends TestCase
{
    // ~ Fields ................................................................
    private CompareByMonth trad1;
    private CompareByMonth trad2;
    private CompareByMonth reach1;
    private CompareByMonth reach2;
    
    private Influencer left;
    private Influencer right;
    
    private InteractionData january;
    private InteractionData february;
    private InteractionData march;
    
    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    public void setUp()
    {
        trad1 = new CompareByMonth(true, 0);
        trad2 = new CompareByMonth(true, 1);

        reach1 = new CompareByMonth(false, 0);
        reach2 = new CompareByMonth(false, 1);
        
        Influencer left = new Influencer("s","s","s","s");
        Influencer right = new Influencer("s","s","s","s");
        
        InteractionData january = 
                    new InteractionData(10, 10, 10, 10, 2, "January");
        
        InteractionData february = 
                    new InteractionData(20, 20, 20, 20, 10, "February");
        
        InteractionData march = 
                    new InteractionData(30, 30, 30, 30, 10, "March");
    }


    public void testCompare()
    {
        left.getMonthData().add(january);
        left.getMonthData().add(february);
        left.getMonthData().add(march);
        
        right.getMonthData().add(january);
        
        assertEquals(trad1.compare(left, right), 0);
    }
}