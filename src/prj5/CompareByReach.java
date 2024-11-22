package prj5;

import java.util.Comparator;
import list.AList;
import prj5.InteractionData;

// -------------------------------------------------------------------------
/**
 * Compare two social media influencers by reach engagement rate, either on a
 * monthly or quarterly scale.
 * 
 * @author bradl
 * @version Nov 19, 2024
 */
public class CompareByReach
    implements Comparator<Influencer>
{
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

    @Override
    public int compare(Influencer left, Influencer right)
    {
        double leftRate = 0.0;
        double rightRate = 0.0;
        AList<InteractionData> leftData = left.getMonthData();
        AList<InteractionData> rightData = right.getMonthData();
        for (InteractionData data : leftData)
        {
            leftRate += data.getReachEngagementRate();
        }
        for (InteractionData data : rightData)
        {
            rightRate += data.getReachEngagementRate();
        }
        return Double.compare(leftRate, rightRate);
    }


    // ----------------------------------------------------------
    /**
     * Determines which set of monthly interaction data has a greater
     * reach engagement rate.
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
        return Double.compare(
            left.getReachEngagementRate()
            right.getReachEngagementRate());
    }
}
