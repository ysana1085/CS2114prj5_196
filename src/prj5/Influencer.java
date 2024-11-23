// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bradley Roos (bradleyroos@vt.edu)

package prj5;

import list.AList;
import java.text.DecimalFormat;

// -------------------------------------------------------------------------
/**
 * @author
 * @version Nov 21, 2024
 */
public class Influencer
    implements Comparable<Influencer>
{
    // ~ Fields ................................................................
    private String username;
    private String channelName;
    private String country;
    private String mainTopic;
    private boolean isTraditional;
    private boolean channelSort;
    private AList<InteractionData> monthData;

    // ~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Create a new Influencer object.
     * 
     * @param username
     *            username of this influencer
     * @param channelName
     *            user handle of this influencer
     * @param country
     *            the country at which the influencer is located
     * @param mainTopic
     *            the main topic this influencer posts about
     */
    public Influencer(
        String username,
        String channelName,
        String country,
        String mainTopic)

    {
        this.username = username;
        this.channelName = channelName;
        this.country = country;
        this.mainTopic = mainTopic;
        monthData = new AList<InteractionData>();
    }


    // ----------------------------------------------------------
    /**
     * Gets the username of the influencer.
     * 
     * @return the username of this influencer.
     */
    // ~Public Methods ........................................................
    public String getUsername()
    {
        return username;
    }


    /**
     * Gets the username of the influencer.
     * 
     * @return the username of this influencer.
     */
    public String getChannelName()
    {
        return channelName;
    }


    /**
     * Gets the country of the influencer.
     * 
     * @return the country of this influencer.
     */
    public String getCountry()
    {
        return country;
    }


    /**
     * Gets the main topic of the influencer.
     * 
     * @return the main topic of this influencer.
     */
    public String getMainTopic()
    {
        return mainTopic;
    }


    /**
     * Gets the list of monthly interaction data of the influencer.
     * 
     * @return the list of monthly interaction data of this influencer.
     */
    public AList<InteractionData> getMonthData()
    {
        return monthData;
    }


    public void setIsTraditional(boolean b)
    {
        isTraditional = b;
    }


    public void setChannelSort(boolean b)
    {
        channelSort = b;
    }


    @Override
    public int compareTo(Influencer other)
    {
        if (isTraditional)
        {
            CompareByTraditional comp = new CompareByTraditional();
            return comp.compare(this, other);
        }
        if (channelSort)
        {
            return this.channelName.toLowerCase()
                .compareTo(other.channelName.toLowerCase());
        }
        CompareByReach comp = new CompareByReach();
        return comp.compare(this, other);
    }


    public String firstQuarterTraditionalEngagementRate() throws SocialMediaException
    {
        DecimalFormat df = new DecimalFormat("#.#");
        double sum = 0.0;
        for (int i = 0; i < monthData.getLength(); i++)
        {
            if(!monthData.getEntry(i).getTraditionalEngagementRate().equals("N/A"))
            {
                sum += monthData.getEntry(i).getComments()
                    + monthData.getEntry(i).getLikes();
                if(monthData.getEntry(i).getMonth().equals("March"))
                {
                    sum /= monthData.getEntry(i).getFollowers();
                    sum *= 100;
                    return df.format(sum);
                }
            }
        }
        throw new SocialMediaException("Cannot find March data.");
    }


    public String firstQuarterReachEngagementRate()
    {
        DecimalFormat df = new DecimalFormat("#.#");
        double sum = 0.0;
        for (int i = 0; i < monthData.getLength(); i++)
        {
            if(!monthData.getEntry(i).getReachEngagementRate().equals("N/A"))
            {
                sum += (monthData.getEntry(i).getComments()
                    + monthData.getEntry(i).getLikes()) / monthData.getEntry(i).getViews();
                
                System.out.println(monthData.getEntry(i).getComments());
            }
        }
        sum *= 100;
        return df.format(sum);

    }


    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (this.getClass() == obj.getClass())
        {
            Influencer other = (Influencer)obj;
            return this.username.equals(other.username)
                && this.channelName.equals(other.channelName)
                && this.country.equals(other.country)
                && this.mainTopic.equals(other.mainTopic);
        }
        return false;
    }
}
