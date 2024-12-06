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

@SuppressWarnings("deprecation")
public class InputFileReader
{

    private static final int VALUES = 10;
    private static final String[] MONTHS =
        { "January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December" };
    private DLinkedList<Influencer> influencers;

    // ----------------------------------------------------------
    /**
     * Create a new InputFileReader object.
     * 
     * @param arg
     *            the file name to read
     * @throws FileNotFoundException
     *             when the file name is not found in the project path
     * @throws ParseException
     *             when the analytics file is missing entries for a user
     */
    public InputFileReader(String arg)
        throws FileNotFoundException,
        ParseException
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


    private void readAnalyticsFile(String file)
        throws ParseException,
        FileNotFoundException
    {

        Scanner inStream = IOHelper.createScanner(file);
        inStream.nextLine();// skip header
        while (inStream.hasNextLine())
        {

            String line = inStream.nextLine().replaceAll(" ", "");
            String[] values = line.split(",");
            if (values.length < VALUES)
            {
                throw new ParseException(
                    "Missing" + (VALUES - values.length) + "value(s)",
                    line.indexOf(
                        values[values.length - 1]
                            + values[values.length - 1].length()));
            }
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


    // ----------------------------------------------------------
    /**
     * Gets a String
     * 
     * @return a String representation of traditional and reach engagement rates
     *             for each user.
     */
    public String printAnalyticsFile()
    {
        StringBuilder sb = new StringBuilder();
        influencers.sort(new CompareByName());
        String channel;
        for (int i = 0; i < influencers.getLength(); i++)
        {
            channel = influencers.getEntry(i).getChannelName();
            sb.append(
                channel + "\ntraditional: "
                    + influencers.getEntry(i).firstQuarterTraditionalEngagementRate());
            sb.append("\n==========\n");
        }
        sb.append("**********\n**********\n");
        influencers.sort(new CompareByReach());
        for (int i = 0; i < influencers.getLength(); i++)
        {
            channel = influencers.getEntry(i).getChannelName();
            sb.append(
                channel + "\nreach: "
                    + influencers.getEntry(i).firstQuarterReachEngagementRate());
            sb.append("\n==========\n");
        }
        return sb.toString();
    }


    private boolean isValidMonth(String month)
        throws ParseException
    {
        for (String s : MONTHS)
        {
            if (s.equals(month))
            {
                return true;
            }
        }
        throw new ParseException("invalid month", 0);
    }


    // ----------------------------------------------------------
    /**
     * Gets the doubly linked list of social media influencers
     * 
     * @return this doubly linked list of social media influencers
     */
    public DLinkedList<Influencer> getInfluencers()
    {
        return influencers;
    }
}
