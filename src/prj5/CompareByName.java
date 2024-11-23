package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * Compares two influencers by their channel name alphabetically, ignoring case,
 * with a comparator interface.
 * 
 * @author bradl
 * @version Nov 22, 2024
 */
public class CompareByName
    implements Comparator<Influencer>
{

    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    @Override
    public int compare(Influencer left, Influencer right)
    {
        return left.getChannelName().toLowerCase()
            .compareTo(right.getChannelName().toLowerCase());
    }
}
