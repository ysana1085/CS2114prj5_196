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
        return right.getChannelName().toLowerCase()
            .compareTo(left.getChannelName().toLowerCase());
    }
}
