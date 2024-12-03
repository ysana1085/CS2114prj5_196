// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bradley Roos (bradleyroos@vt.edu)

package prj5;

import java.util.Comparator;
import list.AList;

// -------------------------------------------------------------------------
/**
 * Compare two social media influencers by Traditional engagement rate, either
 * on a monthly or quarterly scale.
 * 
 * @author bradl
 * @version Nov 19, 2024
 */
public class CompareByTraditional
    implements Comparator<Influencer>
{
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

    @Override
    public int compare(Influencer left, Influencer right)
    {
        return Double.compare(
            Double.parseDouble(right.firstQuarterTraditionalEngagementRate()),
            Double.parseDouble(left.firstQuarterTraditionalEngagementRate()));
    }


    // ----------------------------------------------------------
    /**
     * Determines which set of monthly interaction data has a greater
     * traditional engagement rate.
     * 
     * @param left
     *            the first interaction data object
     * @param right
     *            the first interaction data object
     * @return -1 if left engagement rate > right engagement rate, 0 if left
     *             engagement rate = right engagement, 1 if right engagement
     *             rate > left engagement rate
     */
    public int compareByMonth(InteractionData left, InteractionData right)
    {
        String leftRate = left.getTraditionalEngagementRate();
        String rightRate = right.getTraditionalEngagementRate();
        return Double.compare(
            Double.parseDouble(leftRate),
            Double.parseDouble(rightRate));
    }
}
