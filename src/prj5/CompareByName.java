package prj5;

import java.util.Comparator;

public class CompareByName
    implements Comparator<Influencer>
{

    //~ Fields ................................................................

    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    @Override
    public int compare(Influencer left, Influencer right)
    {
        return left.getChannelName().toLowerCase().compareTo(right.getChannelName().toLowerCase());
    }
}
