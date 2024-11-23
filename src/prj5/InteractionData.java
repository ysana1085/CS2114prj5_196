package prj5;
import java.text.DecimalFormat;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Yashvasin Sana (ysana1085)

// -------------------------------------------------------------------------
/**
 * The InteractionData class models data for a social media influencer's
 * account, including fields for likes, posts, followers, comments, views, and
 * the month. It provides methods to retrieve individual data fields and
 * calculate two types of engagement rates: traditional (based on followers) and
 * reach (based on views).
 * 
 * @author Yashvasin Sana
 * @version Nov 18, 2024
 */
public class InteractionData
{
    // ~ Fields ................................................................
    private int likes;
    private int posts;
    private int followers;
    private int comments;
    private int views;
    private String month;

    // ~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Create a new InteractionData object to store information about an
     * influencer's account and calculate engagement rates.
     * 
     * @param likes
     * @param posts
     * @param followers
     * @param comments
     * @param views
     * @param month
     */

    public InteractionData(
        int likes,
        int posts,
        int followers,
        int comments,
        int views,
        String month)
    {
        this.likes = likes;
        this.posts = posts;
        this.followers = followers;
        this.comments = comments;
        this.views = views;
        this.month = month;
    }


    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * Gets the integer value of the amount of likes on the influencer's
     * channel.
     * 
     * @return amount of likes
     */

    public int getLikes()
    {
        return likes;
    }


    // ----------------------------------------------------------
    /**
     * Gets the integer value of the amount of posts on the influencer's
     * channel.
     * 
     * @return number of posts.
     */
    public int getPosts()
    {
        return posts;
    }


    // ----------------------------------------------------------
    /**
     * Gets the integer value of the amount of followers on the influencer's
     * channel.
     * 
     * @return amount of followers on the channel.
     */
    public int getFollowers()
    {
        return followers;
    }


    // ----------------------------------------------------------
    /**
     * Gets the integer value of the amount of comments on the influencer's
     * channel.
     * 
     * @return amount of comments on the channel.
     */
    public int getComments()
    {
        return comments;
    }


    // ----------------------------------------------------------
    /**
     * Gets the integer value of the amount of views the influencer has
     * accumulated in their channel.
     * 
     * @return amount of views on the channel.
     */
    public int getViews()
    {
        return views;
    }


    // ----------------------------------------------------------
    /**
     * Gets the string value of the month ("January", "Febuary", etc.).
     * 
     * @return the month.
     */
    public String getMonth()
    {
        return month;
    }


    // ----------------------------------------------------------
    /**
     * Calculates engagement rate based off of followers.
     * 
     * @return the traditional engagement rate.
     */
    public String getTraditionalEngagementRate()
    {
        if (followers > 0)
        {
            double rate = (((double)(comments + likes) / followers) * 100);
            DecimalFormat df = new DecimalFormat("#.#");

            return df.format(rate);
        }

        return "N/A";
    }


    // ----------------------------------------------------------
    /**
     * Calculates engagement rate based off of views.
     * 
     * @return the engagement rate by reach.
     */
    public String getReachEngagementRate()
    {
        if (views > 0)
        {
            double rate = (((double)(comments + likes) / views) * 100);
            DecimalFormat df = new DecimalFormat("#.#");

            return df.format(rate);
        }

        return "N/A";
    }
}
