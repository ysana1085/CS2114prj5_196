package prj5;
import list.AList;

// -------------------------------------------------------------------------
/**
 * 
 * 
 * 
 *  @author 
 *  @version Nov 21, 2024
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
}
