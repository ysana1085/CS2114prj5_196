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
 * Represents a social media influencer, which has a username, channel name,
 * country, and main topic of posting. Additionally, the first quarter
 * engagement rate data is contained in a list ADT.e
 * 
 * @author bradl
 * @version Nov 21, 2024
 */
public class Influencer
{
    // ~ Fields ................................................................
    private String username;
    private String channelName;
    private String country;
    private String mainTopic;
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


    // ----------------------------------------------------------
    /**
     * Calculates the first quarter traditional engagement rate with the
     * comments, likes, and followers of a given influencer.
     * 
     * @return A string representation of the traditional engagement rate of the
     *             first quarter for a given influencer.
     */
    public String firstQuarterTraditionalEngagementRate()
    {
        DecimalFormat df = new DecimalFormat("#.#");
        double sum = 0.0;
        for (int i = 0; i < monthData.getLength(); i++)
        {
            if (!monthData.getEntry(i).getTraditionalEngagementRate()
                .equals("N/A"))
            {
                sum += monthData.getEntry(i).getComments()
                    + monthData.getEntry(i).getLikes();

                // todo extend ifstatement to include other months in first
                // quarter.
                if (monthData.getEntry(i).getMonth().equals("March"))
                {
                    sum /= monthData.getEntry(i).getFollowers();
                    sum *= 100;
                    return df.format(sum);
                }
            }
        }
        return df.format(sum);
    }


    // ----------------------------------------------------------
    /**
     * Calculates the first quarter traditional engagement rate with the
     * comments, likes, and views of a given influencer.
     * 
     * @return A string representation of the traditional engagement rate of the
     *             first quarter for a given influencer.
     */
    public String firstQuarterReachEngagementRate()
    {
        DecimalFormat df = new DecimalFormat("#.#");
        double sum = 0.0;
        double viewCount = 0.0;
        for (int i = 0; i < monthData.getLength(); i++)
        {
            if (!monthData.getEntry(i).getReachEngagementRate().equals("N/A"))
            {
                viewCount += monthData.getEntry(i).getViews();
            }
        }
        if (viewCount > 0)
        {
            for (int i = 0; i < monthData.getLength(); i++)
            {
                if (!monthData.getEntry(i).getReachEngagementRate()
                    .equals("N/A"))
                {
                    sum += ((monthData.getEntry(i).getComments()
                        + monthData.getEntry(i).getLikes() * 1.0) / viewCount);
                }
            }
        }
        sum *= 100;
        return df.format(sum);

    }


    @Override
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
