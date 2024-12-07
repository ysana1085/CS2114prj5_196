// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bradley Roos (bradleyroos@vt.edu)

package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * Compares two social media influencers by a specified index which corresponds
 * to a month, and by a specified boolean value determining if the comparison
 * should be calculated with reach or traditional engagement rate.
 * 
 * @author bradl
 * @version Dec 6, 2024
 */
public class CompareByMonth
    implements Comparator<Influencer>
{

    // ~ Fields ................................................................
    private boolean isTraditional;
    private int index;

    // ----------------------------------------------------------
    /**
     * Create a new CompareByMonth object.
     * 
     * @param isTraditional
     *            true if the comparison is traditional engagement rate, false
     *            otherwise
     * @param index
     *            the index of the month data List to access
     */
    // ~ Constructors ..........................................................
    public CompareByMonth(boolean isTraditional, int index)
    {
        this.isTraditional = isTraditional;
        this.index = index;
    }


    // ~Public Methods ........................................................
    @Override
    public int compare(Influencer left, Influencer right)
    {
        double rightEngagementRate;
        double leftEngagementRate;

        String leftTraditional =
            left.getMonthData().getEntry(index).getTraditionalEngagementRate();

        String rightTraditional =
            right.getMonthData().getEntry(index).getTraditionalEngagementRate();

        String leftReach =
            left.getMonthData().getEntry(index).getReachEngagementRate();

        String rightReach =
            right.getMonthData().getEntry(index).getReachEngagementRate();

        if (isTraditional)
        {
            if (leftTraditional.equals("N/A"))
            {
                leftEngagementRate = 0;
            }
            else
            {
                leftEngagementRate = Double.parseDouble(leftTraditional);
            }
            if (rightTraditional.equals("N/A"))
            {
                rightEngagementRate = 0;
            }
            else
            {
                rightEngagementRate = Double.parseDouble(leftTraditional);
            }
        }
        else
        {
            if (leftReach.equals("N/A"))
            {
                leftEngagementRate = 0;
            }
            else
            {
                leftEngagementRate = Double.parseDouble(leftTraditional);
            }
            if (rightReach.equals("N/A"))
            {
                rightEngagementRate = 0;
            }
            else
            {
                rightEngagementRate = Double.parseDouble(leftTraditional);
            }
        }
        return Double.compare(leftEngagementRate, rightEngagementRate);
    }
}
