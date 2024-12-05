// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bradley Roos (bradleyroos@vt.edu)

package prj5;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

import cs1705.IOHelper;

/**
 * 
 */

public class InputFileReader
{

    public static final int VALUES = 10;
    public static final String[] MONTHS =
        { "January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December" }; 
    private DLinkedList<Influencer> influencers;

    public InputFileReader(String arg)
        throws FileNotFoundException,
        ParseException,
        SocialMediaException
    {
        influencers = new DLinkedList<Influencer>();
        readAnalyticsFile(arg);
    }


    private int toInt(String str)
    {
        try
        {
            return Integer.parseInt(str);
        }
        catch (Exception e)
        {
            return 0;
        }
    }


    // ----------------------------------------------------------

    @SuppressWarnings({ "deprecation", "resource" })
    private void readAnalyticsFile(String file)
        throws ParseException,
        FileNotFoundException,
        SocialMediaException
    {

        Scanner inStream = IOHelper.createScanner(file);
        inStream.nextLine();// skip header
        while (inStream.hasNextLine())
        {

            String line = inStream.nextLine().replaceAll(" ", "");
            String[] values = line.split(",");
            String month = values[0];
            String username = values[1];
            String channel = values[2];
            String country = values[3];
            String mainTopic = values[4];
            int likes = toInt(values[5]);
            int posts = toInt(values[6]);
            int followers = toInt(values[7]);
            int comments = toInt(values[8]);
            int views = toInt(values[9]);
            isValidMonth(month);
            Influencer influencer =
                new Influencer(username, channel, country, mainTopic);
            int index = influencers.lastIndexOf(influencer);
            if (index != -1)
            {
                influencers.getEntry(index).getMonthData().add(
                    new InteractionData(
                        likes,
                        posts,
                        followers,
                        comments,
                        views,
                        month));
            }
            else
            {
                influencers.add(influencer);
                influencer.getMonthData().add(
                    new InteractionData(
                        likes,
                        posts,
                        followers,
                        comments,
                        views,
                        month));
            }
        } // end while
        inStream.close();
    }


    public String printAnalyticsFile()
        throws FileNotFoundException,
        SocialMediaException,
        ParseException
    {
        StringBuilder sb = new StringBuilder();
        Influencer[] arr = influencers.toArray();
        influencers.sort(arr, 0, arr.length - 1, new CompareByName());
        for (int i = 0; i < arr.length; i++)
        {
            String channel = arr[i].getChannelName();
            sb.append(
                channel + "\ntraditional: "
                    + arr[i].firstQuarterTraditionalEngagementRate());
            sb.append("\n==========\n");
        }
        sb.append("**********\n**********\n");
        influencers.sort(arr, 0, arr.length - 1, new CompareByReach());
        for (int i = 0; i < influencers.getLength(); i++)
        {
            String channel = arr[i].getChannelName();
            sb.append(
                channel + "\nreach: "
                    + arr[i].firstQuarterReachEngagementRate());
            sb.append("\n==========\n");
        }
        return sb.toString();
    }


    private boolean isValidMonth(String month)
        throws SocialMediaException,
        ParseException
    {
        for (String s : MONTHS)
        {
            if (s.equals(month))
            {
                return true;
            }
        }
        throw new SocialMediaException("invalid month");
    }
    
    public DLinkedList<Influencer> getInfluencers()
    {
        return influencers;
    }
}
