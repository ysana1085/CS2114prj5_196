package prj5;

import list.AList;

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
     * @param monthData
     *            list of months of the influencer
     */
    public Influencer(
        String username,
        String channelName,
        String country,
        String mainTopic,
        AList<InteractionData> monthData)
    {
        this.username = username;
        this.channelName = channelName;
        this.country = country;
        this.mainTopic = mainTopic;
        this.monthData = new AList<InteractionData>();
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


    @Override
    public int compareTo(Influencer o)
    {
        // TODO Auto-generated method stub
        return 0;
    }


    public double getAverageTraditionalEngagementRate()
    {
        double sum = 0;
        for (int i = 0; i < monthData.getLength(); i++)
        {
            String traditional =
                monthData.getEntry(i).getTraditionalEngagementRate();
            sum += Double.parseDouble(
                traditional.substring(0, traditional.indexOf("%")));
        }
        return sum / monthData.getLength();
    }


    public double getAverageReachEngagementRate()
    {
        double sum = 0;
        for (int i = 0; i < monthData.getLength(); i++)
        {
            String reach = monthData.getEntry(i).getReachEngagementRate();
            sum += Double.parseDouble(reach.substring(0, reach.indexOf("%")));
        }
        return sum / monthData.getLength();

    }
}
