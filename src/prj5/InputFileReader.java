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
        outputAnalyticsFile();
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


    public DLinkedList<Influencer> readAnalyticsFile(String file)
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
            influencers.add(influencer);
        } // end while
        inStream.close();
        return influencers;
    }


    private void outputAnalyticsFile()
        throws FileNotFoundException
    {
        PrintWriter writer = new PrintWriter("output.txt");
        for (int i = 0; i < influencers.getLength(); i++)
        {
            String channel = influencers.getEntry(i).getChannelName();
            writer.print(
                channel + "\ntraditional: " + influencers.getEntry(i)
                    .getAverageTraditionalEngagementRate());
            writer.print("__________\n__________");
        }
        writer.print("**********\n\n**********");
        for (int i = 0; i < influencers.getLength(); i++)
        {
            String channel = influencers.getEntry(i).getChannelName();
            writer.print(
                channel + "\nreach: "
                    + influencers.getEntry(i).getAverageReachEngagementRate());
            writer.print("__________\n__________");
        }
        writer.close();
    }


    public String printAnalyticsFile()
        throws FileNotFoundException
    {
        StringBuilder sb = new StringBuilder();
        Scanner sc = IOHelper.createScanner("output.txt");
        while (sc.hasNextLine())
        {
            sb.append(sc.nextLine());
        }
        return sb.toString();
    }


    private void isValidMonth(String month)
        throws SocialMediaException
    {
        for (String s : MONTHS)
        {
            if (s.equals(month))
            {
                return;
            }
        }
        throw new SocialMediaException("invalid month");
    }
}
